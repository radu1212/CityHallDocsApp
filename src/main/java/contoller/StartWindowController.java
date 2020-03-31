package contoller;

import entity.Address;
import entity.Document;
import entity.Request;
import entity.User;
import net.bytebuddy.utility.RandomString;
import repository.AddressRepo;
import repository.DocumentRepo;
import repository.RequestRepo;
import repository.UserRepo;
import service.AddressService;
import service.DocumentService;
import service.RequestService;
import service.UserService;
import sun.security.provider.SecureRandom;
import utilities.EmailSender;
import utilities.ReportMessages;
import validators.EmailValidator;
import validators.PasswordValidator;
import validators.UsernameValidator;
import view.*;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StartWindowController {

    private StartWindow             startWindow ;
    private LoginWindow             loginWindow;
    private RegisterWindow          registerWindow;
    private AddAddressWindow        addAddressWindow;
    private MainPage                mainPage;
    private UpdateInfoWindow        updateInfoWindow;
    private ChangePasswordWindow    changePasswordWindow;
    private ChangeEmailWindow       changeEmailWindow;
    private AddNewRequestWindow     addNewRequestWindow;
    private AdminMainPage           adminMainPage;
    private AddDocumentsWindow      addDocumentsWindow;
    private DeleteDocumentWindow    deleteDocumentWindow;
    private ForgottenPasswordWindow forgottenPasswordWindow;
    private KeyCheck                keyCheck;

    private boolean mousePressed;

    public StartWindowController() {

        startWindow             = new StartWindow();
        loginWindow             = new LoginWindow();
        registerWindow          = new RegisterWindow();
        addAddressWindow        = new AddAddressWindow("Please insert the address you currently live at:");
        mainPage                = new MainPage();
        updateInfoWindow        = new UpdateInfoWindow();
        changePasswordWindow    = new ChangePasswordWindow();
        changeEmailWindow       = new ChangeEmailWindow();
        adminMainPage           = new AdminMainPage();
        addDocumentsWindow      = new AddDocumentsWindow();
        deleteDocumentWindow    = new DeleteDocumentWindow();
        forgottenPasswordWindow = new ForgottenPasswordWindow();
        keyCheck                = new KeyCheck();

        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd   HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                mainPage.getLabel2().setText("Date / Time :     " + dtf.format(now));
                adminMainPage.getLabel2().setText("Date / Time :     " + dtf.format(now));
                mainPage.getLabel1().setText("Welcome back:     " + loginWindow.getTextField1());
            }
        };
        new Timer(delay, taskPerformer).start();
        startWindow.setVisible(true);
        initializeStartPageButtonListeners();
    }

    private void initializeStartPageButtonListeners() {

        startWindow.addLoginButtonActionListener(e->{
            loginWindow.setVisible(true);
            startWindow.setVisible(false);
        });

        startWindow.addRegisterButtonActionListener(e->{
            registerWindow.setVisible(true);
            startWindow.setVisible(false);
        });
        //                                      START WINDOW BUTTONS

        registerWindow.addOkButtonActionListener(e->{

            String messageToBeDisplayed = "";
            if (Boolean.FALSE.equals(UsernameValidator.validateUsername(registerWindow.getTextField1()))) {
                messageToBeDisplayed += ReportMessages.usernameNotValid() + '\n';
                registerWindow.resetUsername();
            }
            if (Boolean.FALSE.equals(EmailValidator.validateEmail(registerWindow.getTextField2()))){
                messageToBeDisplayed += ReportMessages.invalidEmail() + '\n';
                registerWindow.resetEmail();
            }
            if (! registerWindow.getPasswordField1().equals(registerWindow.getPasswordField2())){
                messageToBeDisplayed += ReportMessages.passwordsDontMatch() + '\n';
                registerWindow.resetPasswords();
            }
            if (Boolean.FALSE.equals(PasswordValidator.validatePassword(registerWindow.getPasswordField1())) ||
                    Boolean.FALSE.equals(PasswordValidator.validatePassword(registerWindow.getPasswordField2()))) {
                messageToBeDisplayed += ReportMessages.invalidPassword() + '\n';
                registerWindow.resetPasswords();
            }
            if (messageToBeDisplayed.equals("")) {
                try{
                    if (new UserRepo().getUserByUsername1(registerWindow.getTextField1()).isEmpty()){
                        new UserRepo().insertNewUser(registerWindow.getTextField1(), registerWindow.getTextField2(),registerWindow.getPasswordField1());
                        PopUpMessageWindow.infoBox(ReportMessages.registrationSuccessful());
                        registerWindow.setVisible(false);
                        startWindow.setVisible(true);
                    }
                    else {
                        PopUpMessageWindow.infoBox(ReportMessages.usernameOrEmailAlreadyRegistered());
                        registerWindow.resetPasswords();
                        registerWindow.resetEmail();
                        registerWindow.resetUsername();
                    }
                }catch (NullPointerException ex){
                    PopUpMessageWindow.infoBox(ReportMessages.usernameOrEmailAlreadyRegistered());
                }
            }
            else
                PopUpMessageWindow.infoBox(messageToBeDisplayed);
        });

        registerWindow.addCancelButtonActionListener(e->{
            registerWindow.setVisible(false);
            startWindow.setVisible(true);
        });

        registerWindow.addDisplayButtonActionListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                new Thread() {
                    public void run() {
                        while (mousePressed) {
                            registerWindow.getPasswordField1Obj().setEchoChar((char)0);
                            registerWindow.getPasswordField2Obj().setEchoChar((char)0);
                        }
                    }

                }.start();
            }
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                registerWindow.getPasswordField1Obj().setEchoChar('*');
                registerWindow.getPasswordField2Obj().setEchoChar('*');
            }
        });
        //                                                  REGISTER WINDOW BUTTONS


        loginWindow.addDisplayButtonActionListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                new Thread() {
                    public void run() {
                        while (mousePressed) {
                            loginWindow.getPasswordField1Obj().setEchoChar((char)0);
                        }
                    }

                }.start();
            }
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                loginWindow.getPasswordField1Obj().setEchoChar('*');
            }
        });


        loginWindow.addCancelButtonActionListener(e->{
            PopUpMessageWindow.infoBox(ReportMessages.areYouSureExit(),"");
            loginWindow.dispatchEvent(new WindowEvent(loginWindow, WindowEvent.WINDOW_CLOSING));
        });


        loginWindow.addOkButtonActionListener(e->{
            /*
            *
            *   Validations for login input
            *
            */
            String messageToBeDisplayed = "";
            if (Boolean.FALSE.equals(UsernameValidator.validateUsername(loginWindow.getTextField1()))) {
                messageToBeDisplayed += ReportMessages.usernameNotValid() + '\n';
                loginWindow.resetUsername();
                loginWindow.resetPassword();
            }
            if (Boolean.FALSE.equals(PasswordValidator.validatePassword(loginWindow.getPasswordField1()))) {
                messageToBeDisplayed += ReportMessages.invalidCredentials() + '\n';
                loginWindow.resetPassword();
            }
            if (messageToBeDisplayed.equals("")) {
                if(new UserService().checkLoginCredentials(loginWindow.getTextField1(), loginWindow.getPasswordField1())) {
                    PopUpMessageWindow.infoBox(ReportMessages.loginSuccessful(), "Success");
                    loginWindow.setVisible(false);
                    if(new UserRepo().getUserByUsername(loginWindow.getTextField1()).getRole().equals(Boolean.FALSE)) {
                        if (new UserService().getUserRepo().getUserByUsername(loginWindow.getTextField1()).getAddresses().isEmpty())
                            addAddressWindow.setVisible(true);
                        else {
                            mainPage.setLabel1(new JLabel("Welcome back: " + loginWindow.getTextField1()));
                            if (new RequestRepo().getRequests(new UserService().getUserRepo().getUserByUsername(loginWindow.getTextField1())) != null) {
                                for (Request request : new RequestRepo().getRequests(new UserService().getUserRepo().getUserByUsername(loginWindow.getTextField1()))) {
                                    mainPage.yourAddRow(request.getDocument(), request.getTime(), request.getStatus(), request.getAddress());
                                }
                            }
                            //updateInfoWindow = new UpdateInfoWindow();
                            List<Address> addresses = new UserRepo().getUserByUsername(loginWindow.getTextField1()).getAddresses();
                            DefaultListModel<String> model = new DefaultListModel<>();
                            for (Address address : addresses) {
                                String addr = "   " + address.getStreet()
                                        + ", no. " + address.getNumber()
                                        + ", ap. " + address.getApartment()
                                        + ", " + address.getCity()
                                        + ", " + address.getCounty();
                                model.addElement(addr);
                            }
                            updateInfoWindow.getList1().setModel(model);
                            mainPage.invalidate();
                            mainPage.validate();
                            mainPage.repaint();
                            mainPage.setVisible(true);
                        }
                    }
                    else { // ADMIN LOGIN
                        List<User> users = UserService.getAllUsers();
                        List<String> usernames = new ArrayList<>();
                        for(User user : users){
                            if(user.getRole().equals(Boolean.FALSE))
                                usernames.add(user.getUsername());
                        }
                        List<String> sortedNames = usernames.stream().sorted().collect(Collectors.toList());
                        DefaultListModel<String> model = new DefaultListModel<>();
                        for (String user : sortedNames) {
                            model.addElement(user);
                        }
                        adminMainPage.getList1().setModel(model);
                        adminMainPage.setVisible(true);
                    }
                }
                else {
                    PopUpMessageWindow.infoBox(ReportMessages.invalidCredentials(), "Fail");
                    loginWindow.resetPassword();
                    loginWindow.resetUsername();
                }
            }
            else
                PopUpMessageWindow.infoBox(messageToBeDisplayed);
        });

        loginWindow.addPasswordForgottenButtonActionListener(e->{
            forgottenPasswordWindow.setVisible(true);
        });

        forgottenPasswordWindow.addSendEmailButtonActionListener(e->{
            User user = new UserRepo().getUserByUsername(forgottenPasswordWindow.getTextField1());
            try {
                EmailSender.sendMail(user.getEmail(), "Your password", user.getPassword());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            forgottenPasswordWindow.setVisible(false);
        });

        forgottenPasswordWindow.addCancelButtonActionListener(e->{
            forgottenPasswordWindow.setVisible(false);
        });

        //                                              LOGIN WINDOW BUTTONS

        adminMainPage.addViewSelectedUsersRequestsButtonActionListener(e->{
            DefaultTableModel dtm = (DefaultTableModel)adminMainPage.getTable1().getModel();
            dtm.setRowCount(0);
            try {
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                try {
                    List<Request> userRequests = RequestService.getRequests(user);
                    for (Request request : Objects.requireNonNull(userRequests)) {
                        adminMainPage.yourAddRow(request.getDocument(), request.getTime(), request.getStatus(), request.getAddress());
                    }
                } catch (NullPointerException ex) {
                    PopUpMessageWindow.infoBox("The selected user has no requests filed");
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addApproveRequestButtonActionListener(e->{
            try{
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                List<Request> requests = new RequestRepo().getRequests(user);
                for(Request request : requests){
                    if(request.getTime().equals(adminMainPage.getTable1().getValueAt(adminMainPage.getTable1().getSelectedRow(), 1))){
                        if(request.getStatus().equals("Pending")) {
                            request.setStatus("Approved");
                            new RequestRepo().changeStatus(request.getId(), "Approved");
                            adminMainPage.getTable1().getModel().setValueAt("Approved", adminMainPage.getTable1().getSelectedRow(), 2);
                            ((DefaultTableModel) adminMainPage.getTable1().getModel()).fireTableCellUpdated(adminMainPage.getTable1().getSelectedRow(), 2);
                            try {
                                EmailSender.sendMail(user.getEmail(), "Status update", "Your request for \n'" + request.getDocument() + "'\nwas approved!");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        else
                            PopUpMessageWindow.infoBox("The request was already verified, and the status updated");
                    }
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addDeclineRequestButtonActionListener(e->{
            try{
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                List<Request> requests = new RequestRepo().getRequests(user);
                for(Request request : requests){
                    if(request.getTime().equals(adminMainPage.getTable1().getValueAt(adminMainPage.getTable1().getSelectedRow(), 1))){
                        if(request.getStatus().equals("Pending")) {
                            request.setStatus("Declined");
                            new RequestRepo().changeStatus(request.getId(), "Declined");
                            adminMainPage.getTable1().getModel().setValueAt("Declined", adminMainPage.getTable1().getSelectedRow(), 2);
                            ((DefaultTableModel) adminMainPage.getTable1().getModel()).fireTableCellUpdated(adminMainPage.getTable1().getSelectedRow(), 2);
                            try {
                                EmailSender.sendMail(user.getEmail(), "Status update", "Your request for \n'" + request.getDocument() + "'\nwas declined!");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        else
                            PopUpMessageWindow.infoBox("The request was already verified, and the status updated");
                    }
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addNewDocumentButtonActionListener(e->{
            addDocumentsWindow.setVisible(true);
            addDocumentsWindow.addConfirmButtonActionListener(e1 -> {
                if(addDocumentsWindow.getCheckBox1().isSelected() && ! addDocumentsWindow.getCheckBox2().isSelected()){
                    Document document = new Document(addDocumentsWindow.getTextField1(),Boolean.TRUE);
                    new DocumentRepo().insertNewDocument(document);
                } else if(addDocumentsWindow.getCheckBox2().isSelected() && ! addDocumentsWindow.getCheckBox1().isSelected()) {
                    Document document = new Document(addDocumentsWindow.getTextField1(),Boolean.FALSE);
                    new DocumentRepo().insertNewDocument(document);
                } else if (addDocumentsWindow.getCheckBox2().isSelected() && addDocumentsWindow.getCheckBox1().isSelected()){
                    PopUpMessageWindow.infoBox("Choose only one checkbox please!");
                }else PopUpMessageWindow.infoBox("You have to select at least one checkbox!");
                addDocumentsWindow.setVisible(false);
            });
        });

        adminMainPage.addDeleteDocumentButtonActionListener(e->{
            List<Document> documents = DocumentService.getDocuments();
            List<String> docs = new ArrayList<>();
            for(Document document : documents){
                docs.add(document.getTitle());
            }
            List<String> sortedDocuments = docs.stream().sorted().collect(Collectors.toList());
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String doc : sortedDocuments) {
                model.addElement(doc);
            }
            deleteDocumentWindow.getList1().setModel(model);
            deleteDocumentWindow.setVisible(true);
        });

        deleteDocumentWindow.addDeleteButtonActionListener(e->{
            new DocumentRepo().deleteDocument(deleteDocumentWindow.getList1().getSelectedValue().toString());
            DefaultListModel model = (DefaultListModel) deleteDocumentWindow.getList1().getModel();
            int selectedIndex = deleteDocumentWindow.getList1().getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
            deleteDocumentWindow.setVisible(false);
        });

        deleteDocumentWindow.addCancelButtonActionListener(e->{
            deleteDocumentWindow.setVisible(false);
        });

        adminMainPage.addDeleteUserButtonActionListener(e->{
            new RequestRepo().deleteUserRequests(new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString()));
            new AddressRepo().deleteUserAddresses(adminMainPage.getList1().getSelectedValue().toString());
            new UserRepo().deleteUser(adminMainPage.getList1().getSelectedValue().toString());
            DefaultListModel model = (DefaultListModel) adminMainPage.getList1().getModel();
            int selectedIndex = adminMainPage.getList1().getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
            DefaultTableModel dtm = (DefaultTableModel)adminMainPage.getTable1().getModel();
            dtm.setRowCount(0);
        });

        adminMainPage.addFilterPendingButtonActionListener(e->{
            DefaultTableModel dtm = (DefaultTableModel)adminMainPage.getTable1().getModel();
            dtm.setRowCount(0);
            try {
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                try {
                    List<Request> userRequests = RequestService.getRequests(user);
                    for (Request request : Objects.requireNonNull(userRequests)) {
                        if(request.getStatus().equals("Pending")) {
                            adminMainPage.yourAddRow(request.getDocument(), request.getTime(), request.getStatus(), request.getAddress());
                        }
                    }
                } catch (NullPointerException ex) {
                    PopUpMessageWindow.infoBox("The selected user has no requests filed");
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addSortByDateButtonActionListener(e->{
            DefaultTableModel dtm = (DefaultTableModel)adminMainPage.getTable1().getModel();
            dtm.setRowCount(0);
            try {
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                try {
                    List<Request> userRequests = RequestService.getRequests(user);
                    List<String> requestDate   = new ArrayList<>();
                    for (Request request : Objects.requireNonNull(userRequests)) {
                        requestDate.add(request.getTime());
                    }
                    java.util.Collections.sort(requestDate);
                    java.util.Collections.reverse(requestDate);
                    for(String req : requestDate) {
                        for(Request request : Objects.requireNonNull(userRequests)){
                            if (request.getTime().equals(req)) {
                                adminMainPage.yourAddRow(request.getDocument(), request.getTime(), request.getStatus(), request.getAddress());
                            }
                        }

                    }
                } catch (NullPointerException ex) {
                    PopUpMessageWindow.infoBox("The selected user has no requests filed");
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addSortByDateAndFilterButtonActionListener(e->{
            DefaultTableModel dtm = (DefaultTableModel)adminMainPage.getTable1().getModel();
            dtm.setRowCount(0);
            try {
                User user = new UserRepo().getUserByUsername(adminMainPage.getList1().getSelectedValue().toString());
                try {
                    List<Request> userRequests = RequestService.getRequests(user);
                    List<String> requestDate   = new ArrayList<>();
                    for (Request request : Objects.requireNonNull(userRequests)) {
                        requestDate.add(request.getTime());
                    }
                    java.util.Collections.sort(requestDate);
                    java.util.Collections.reverse(requestDate);
                    for(String req : requestDate) {
                        for(Request request : Objects.requireNonNull(userRequests)){
                            if (request.getTime().equals(req) && request.getStatus().equals("Pending")) {
                                adminMainPage.yourAddRow(request.getDocument(), request.getTime(), request.getStatus(), request.getAddress());
                            }
                        }

                    }
                } catch (NullPointerException ex) {
                    PopUpMessageWindow.infoBox("The selected user has no requests filed");
                }
            }catch (NullPointerException ex){
                PopUpMessageWindow.infoBox("You did not select any user");
            }
        });

        adminMainPage.addExitButtonActionListener(e->{
            System.exit(0);
        });

        addAddressWindow.addOkButtonActionListener(e->{
            Address address = new Address(addAddressWindow.getTextField1()
                    , addAddressWindow.getTextField2()
                    , addAddressWindow.getTextField3()
                    , addAddressWindow.getTextField4()
                    , addAddressWindow.getComboBox1()
                    , new UserService().getUserRepo().getUserByUsername(loginWindow.getTextField1()));
            new AddressService().addValidatedAddressToDB(address);
            new UserService().getUserRepo()
                    .getUserByUsername(loginWindow.getTextField1())
                    .getAddresses()
                    .add(address);
            addAddressWindow.setVisible(false);
            mainPage.setVisible(true);
        });

        addAddressWindow.addCancelButtonActionListener(e->{
            PopUpMessageWindow.infoBox(ReportMessages.areYouSureExit(),"");
            addAddressWindow.dispatchEvent(new WindowEvent(addAddressWindow, WindowEvent.WINDOW_CLOSING));
        });
        //                                                      ADD ADDRESS WINDOW BUTTONS


        mainPage.addUpdatePersonalInoButtonActionListener(e->{
            updateInfoWindow.setLabel2(loginWindow.getTextField1());
            updateInfoWindow.setLabel4(new UserRepo().getUserByUsername(loginWindow.getTextField1()).getEmail());
            updateInfoWindow.setLabel6(loginWindow.getPasswordField1());
            List<Address> addresses = new UserRepo().getUserByUsername(loginWindow.getTextField1()).getAddresses();
            DefaultListModel<String> model = new DefaultListModel<>();
            for(Address address : addresses){
                String addr = "   " + address.getStreet()
                        + ", no. "  + address.getNumber()
                        + ", ap. "  + address.getApartment()
                        + ", "      + address.getCity()
                        + ", "      + address.getCounty();
                model.addElement(addr);
            }
            updateInfoWindow.getList1().setModel(model);
            updateInfoWindow.invalidate();
            updateInfoWindow.validate();
            updateInfoWindow.repaint();
            updateInfoWindow.setVisible(true);
        });

        mainPage.addLogoutButtonActionListener(e->{
            mainPage.setVisible(false);
            new StartWindowController();
        });

        mainPage.addCreateNewRequestButtonActionListener(e->{
            addNewRequestWindow = new AddNewRequestWindow("Add request", "Please select the document you need:");
            List<Document> documents = new DocumentRepo().getDocuments();
            for(Document document : documents){
                addNewRequestWindow.getComboBox1().addItem(document.getTitle());
            }
            addNewRequestWindow.setVisible(true);

            addNewRequestWindow.addOkButtonActionListener(t->{
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd   HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                Request request = new Request(dtf.format(now), new UserRepo().getUserByUsername(loginWindow.getTextField1()));
                request.setDocument(addNewRequestWindow.getComboBox2());
                for (Document document : documents) {
                    if (document.getTitle().equals(request.getDocument())) {
                        if (document.getRequires_address().equals(Boolean.TRUE)) {
                            AddNewRequestWindow selectAddressForRequest = new AddNewRequestWindow("Select address", "Please choose one of your addresses for your request:");
                            for (int j = 0; j < updateInfoWindow.getList1().getModel().getSize(); j++) {
                                Address address = new AddressRepo().getAddresses(new UserRepo().getUserByUsername(loginWindow.getTextField1())).get(j);
                                String addr = "   " + address.getStreet()
                                        + ", no. "  + address.getNumber()
                                        + ", ap. "  + address.getApartment()
                                        + ", "      + address.getCity()
                                        + ", "      + address.getCounty();
                                selectAddressForRequest.getComboBox1().addItem(addr);
                                selectAddressForRequest.invalidate();
                                selectAddressForRequest.validate();
                                selectAddressForRequest.repaint();
                            }
                            selectAddressForRequest.setVisible(true);
                            addNewRequestWindow.setVisible(false);
                            selectAddressForRequest.addOkButtonActionListener(s -> {
                                int i = 0;
                                List<Request> requests = new ArrayList<>();
                                try {
                                    if (Boolean.FALSE.equals(new RequestRepo().getRequests((new UserRepo().getUserByUsername(loginWindow.getTextField1()))).isEmpty())) {
                                        requests = RequestService.getRequests(new UserRepo().getUserByUsername(loginWindow.getTextField1()));
                                        for (Request request1 : Objects.requireNonNull(requests)) {
                                            if (request1.getDocument().equals(addNewRequestWindow.getComboBox2())
                                                    && (request1.getStatus().equals("Pending") || request1.getStatus().equals("Canceled"))
                                                    && request1.getAddress().equals(selectAddressForRequest.getComboBox2())){
                                                    i++;
                                            }
                                        }
                                    }
                                }
                                catch (NullPointerException ignored){ }
                                if(i<3) {
                                    request.setAddress(selectAddressForRequest.getComboBox2());
                                    new RequestRepo().insertNewRequest(request);
                                    mainPage.yourAddRow(addNewRequestWindow.getComboBox2(), dtf.format(now), request.getStatus(), request.getAddress());
                                    addNewRequestWindow.setVisible(false);
                                    selectAddressForRequest.setVisible(false);
                                }
                                else {
                                    PopUpMessageWindow.infoBox("There are already 3 such requests on that address!");
                                    selectAddressForRequest.setVisible(false);
                                }
                            });
                            selectAddressForRequest.addCancelButtonActionListener(s -> {
                                addNewRequestWindow.setVisible(false);
                                selectAddressForRequest.setVisible(false);
                            });
                        } else {
                            request.setAddress(null);
                            new RequestRepo().insertNewRequest(request);
                            mainPage.yourAddRow(addNewRequestWindow.getComboBox2(), dtf.format(now), request.getStatus());
                            addNewRequestWindow.setVisible(false);
                        }
                    }
                }
            });

            addNewRequestWindow.addCancelButtonActionListener(t->{
                addNewRequestWindow.setVisible(false);
            });
        });

        mainPage.addUpdateRequestButtonActionListener(e->{
            String requestDate = mainPage.getTable1().getValueAt(mainPage.getTable1().getSelectedRow(), mainPage.getTable1().getSelectedColumn()).toString();
            List<Request> requests = RequestService.getRequests(new UserRepo().getUserByUsername(loginWindow.getTextField1()));
            List<Document> documents = DocumentService.getDocuments();
            AddNewRequestWindow addNewRequestWindow1 = new AddNewRequestWindow("Update request", "Please select the new address for the request:");
            for(int i = 0; i < updateInfoWindow.getList1().getModel().getSize(); i++){
                addNewRequestWindow1.addDocumentsToCombobox(updateInfoWindow.getList1().getModel().getElementAt(i).toString());
            }
            for(Request request : Objects.requireNonNull(requests)){
                if (request.getTime().equals(requestDate)) {
                    for(Document document : Objects.requireNonNull(documents)){
                        if(document.getTitle().equals(request.getDocument())) {
                            if(document.getRequires_address().equals(Boolean.TRUE)) {
                                addNewRequestWindow1.setVisible(true);
                                addNewRequestWindow1.addOkButtonActionListener(t -> {
                                    new RequestRepo().updateRequest(request.getId(), addNewRequestWindow1.getComboBox2());
                                    mainPage.getTable1().getModel().setValueAt(addNewRequestWindow1.getComboBox2(), mainPage.getTable1().getSelectedRow(), 3);
                                    ((DefaultTableModel) mainPage.getTable1().getModel()).fireTableCellUpdated(mainPage.getTable1().getSelectedRow(), 3);
                                    addNewRequestWindow1.setVisible(false);
                                });
                                addNewRequestWindow1.addCancelButtonActionListener(t->{
                                    addNewRequestWindow1.setVisible(false);
                                });
                            }
                            else
                                PopUpMessageWindow.infoBox("Since the selected request does not need an address to be filed,\n"+
                                        "you can not update the request!\n"+
                                        "You may want to consider the cancelation if the request was not filed properly!");
                        }
                    }
                }
            }
        });

        mainPage.addDeleteRequestButtonActionListener(e->{
            String requestDate = mainPage.getTable1().getValueAt(mainPage.getTable1().getSelectedRow(), mainPage.getTable1().getSelectedColumn()).toString();
            List<Request> requests = new RequestRepo().getRequests(new UserRepo().getUserByUsername(loginWindow.getTextField1()));
            for(Request request : requests){
                if (request.getTime().equals(requestDate)) {
                    new RequestRepo().deleteRequest1(request.getTime());
                    ((DefaultTableModel)mainPage.getTable1().getModel()).removeRow(mainPage.getTable1().getSelectedRow());
                }
            }
        });

        mainPage.addEmailDocumentButtonActionListener(e->{
            try {
                if(mainPage.getTable1().getValueAt(mainPage.getTable1().getSelectedRow(), 2).equals("Approved"))
                    EmailSender.sendMail((new UserRepo().getUserByUsername(loginWindow.getTextField1()).getEmail())
                            , "Requested documents"
                            , "Attached down below you will find the documents that you have recently requested on our online platform\n\n\n\n"
                                    + mainPage.getTable1().getValueAt(mainPage.getTable1().getSelectedRow(),0)
                                    + "\n\nThe address associated to the request is: \n"
                                    + mainPage.getTable1().getValueAt(mainPage.getTable1().getSelectedRow(),3));
                else PopUpMessageWindow.infoBox("Your request was not yet approved by an admin or has been declined","Waiting for approval");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //                                                 MAIN PAGE WINDOW BUTTOMS

        updateInfoWindow.addChangePasswordButtonActionListener(e->{
            changePasswordWindow.getPasswordField12().setText("");
            changePasswordWindow.getPasswordField13().setText("");
            changePasswordWindow.setVisible(true);
        });

        updateInfoWindow.addCancelButtonActionListener(e->{
            updateInfoWindow.dispatchEvent(new WindowEvent(updateInfoWindow, WindowEvent.WINDOW_CLOSING));
        });

        changePasswordWindow.addConfirmButtonActionListener(e->{
            String messageToBeDisplayed = "";
            if (! changePasswordWindow.getPasswordField2().equals(changePasswordWindow.getPasswordField3())){
                messageToBeDisplayed += ReportMessages.passwordsDontMatch() + '\n';
                changePasswordWindow.resetPasswords();
            }
            if (Boolean.FALSE.equals(PasswordValidator.validatePassword(changePasswordWindow.getPasswordField2()))) {
                messageToBeDisplayed += ReportMessages.invalidPassword() + '\n';
                changePasswordWindow.resetPasswords();
            }
            if (Boolean.FALSE.equals(PasswordValidator.validatePassword(changePasswordWindow.getPasswordField3()))) {
                messageToBeDisplayed += ReportMessages.invalidPassword() + '\n';
                changePasswordWindow.resetPasswords();
            }
            if (messageToBeDisplayed.equals("")) {
                keyCheck.getTextField().setText("");
                keyCheck.setVisible(true);
                int leftLimit = 48; // numeral '0'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 10;
                Random random = new Random();
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                System.out.println("\n\n\n" + generatedString + "\n\n\n");
                try {
                    EmailSender.sendMail(new UserRepo().getUserByUsername(loginWindow.getTextField1()).getEmail(),"Token for password change: \n\n",
                            generatedString);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                keyCheck.addConfirmButtonActionListener(t->{
                    if(keyCheck.getTextField1().equals(generatedString)){
                        new UserRepo().changePassword(new UserRepo().getUserByUsername(loginWindow.getTextField1()).getId(),changePasswordWindow.getPasswordField2());
                        PopUpMessageWindow.infoBox(ReportMessages.passwordChangedSuccessfully());
                        changePasswordWindow.setVisible(false);
                        keyCheck.setVisible(false);
                        updateInfoWindow.getLabel6().setText(changePasswordWindow.getPasswordField2());
                        updateInfoWindow.invalidate();
                        updateInfoWindow.validate();
                        updateInfoWindow.repaint();
                    }
                    else {
                        PopUpMessageWindow.infoBox("The key was incorrect!");
                        keyCheck.setVisible(false);
                    }
                });
                keyCheck.addCancelButtonActionListener(t->{
                    keyCheck.setVisible(false);
                    changePasswordWindow.setVisible(false);
                });
            }
            else
                PopUpMessageWindow.infoBox(messageToBeDisplayed);
        });

        changePasswordWindow.addCancelButtonActionListener(e->{
            changePasswordWindow.dispatchEvent(new WindowEvent(changePasswordWindow, WindowEvent.WINDOW_CLOSING));
        });

        updateInfoWindow.addUpdateEmailButtonActionListener(e->{
            changeEmailWindow.setVisible(true);
        });

        changeEmailWindow.addConfirmButtonActionListener(e->{
            String messageToBeDisplayed = "";
            if (Boolean.FALSE.equals(EmailValidator.validateEmail(changeEmailWindow.getTextField1()))){
                messageToBeDisplayed += ReportMessages.invalidEmail() + '\n';
                changeEmailWindow.resetEmail();
            }
            if (messageToBeDisplayed.equals("")) {
                new UserRepo().changeEmail(new UserRepo().getUserByUsername(loginWindow.getTextField1()).getId(),changeEmailWindow.getTextField1());
                PopUpMessageWindow.infoBox(ReportMessages.emailChangedSuccessfully());
                changeEmailWindow.setVisible(false);
                updateInfoWindow.getLabel4().setText(changeEmailWindow.getTextField1());
                updateInfoWindow.invalidate();
                updateInfoWindow.validate();
                updateInfoWindow.repaint();
            }
            else
                PopUpMessageWindow.infoBox(messageToBeDisplayed);
        });

        updateInfoWindow.addInsertNewAddressButtonActionListener(e->{
            AddAddressWindow addAddressWindow1 = new AddAddressWindow("Please insert the details of your new address: ");
            addAddressWindow1.setVisible(true);

            addAddressWindow1.addOkButtonActionListener(t->{
                Address address = new Address(addAddressWindow1.getTextField1()
                        , addAddressWindow1.getTextField2()
                        , addAddressWindow1.getTextField3()
                        , addAddressWindow1.getTextField4()
                        , addAddressWindow1.getComboBox1()
                        , new UserService().getUserRepo().getUserByUsername(loginWindow.getTextField1()));
                new AddressService().addValidatedAddressToDB(address);
                new UserService().getUserRepo()
                        .getUserByUsername(loginWindow.getTextField1())
                        .getAddresses()
                        .add(address);
                List<Address> addresses = new UserRepo().getUserByUsername(loginWindow.getTextField1()).getAddresses();
                DefaultListModel<String> model = new DefaultListModel<>();
                for(Address address1 : addresses){
                    String addr = "   " + address1.getStreet()
                            + ", no. "  + address1.getNumber()
                            + ", ap. "  + address1.getApartment()
                            + ", "      + address1.getCity()
                            + ", "      + address1.getCounty();
                    model.addElement(addr);
                }
                updateInfoWindow.getList1().setModel(model);
                addAddressWindow1.setVisible(false);
                updateInfoWindow.invalidate();
                updateInfoWindow.validate();
                updateInfoWindow.repaint();
                updateInfoWindow.getList1().updateUI();
            });

            addAddressWindow1.addCancelButtonActionListener(t->{
                PopUpMessageWindow.infoBox(ReportMessages.areYouSureExit(),"");
                addAddressWindow1.dispatchEvent(new WindowEvent(addAddressWindow1, WindowEvent.WINDOW_CLOSING));
            });
        });

    }
}
