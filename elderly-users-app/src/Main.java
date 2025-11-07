import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    
    private Stage primaryStage;
    private VBox mainLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Simple Tech Helper - For Everyone");
        
        // Create main layout
        mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #f5f5f5;");
        
        // Show welcome screen
        showWelcomeScreen();
        
        Scene scene = new Scene(mainLayout, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void showWelcomeScreen() {
        mainLayout.getChildren().clear();
        
        Label title = new Label("Welcome to Simple Tech Helper");
        title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        Label subtitle = new Label("Making Technology Easy for Everyone");
        subtitle.setStyle("-fx-font-size: 18px; -fx-text-fill: #7f8c8d;");
        
        Button startButton = new Button("Get Started");
        startButton.setStyle("-fx-font-size: 16px; -fx-padding: 15px 40px; -fx-background-color: #3498db; -fx-text-fill: white;");
        startButton.setOnAction(e -> showMainMenu());
        
        VBox welcomeBox = new VBox(15);
        welcomeBox.setAlignment(Pos.CENTER);
        welcomeBox.getChildren().addAll(title, subtitle, startButton);
        
        mainLayout.getChildren().add(welcomeBox);
    }
    
    private void showMainMenu() {
        mainLayout.getChildren().clear();
        
        Label menuTitle = new Label("What would you like to do?");
        menuTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        VBox menuBox = new VBox(15);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setMaxWidth(400);
        
        Button formButton = createMenuButton("Fill Out a Form", "Fill out forms easily with our simple interface");
        formButton.setOnAction(e -> showFormScreen());
        
        Button emailButton = createMenuButton("Send an Email", "Send emails the easy way");
        emailButton.setOnAction(e -> showEmailScreen());
        
        Button settingsButton = createMenuButton("Settings", "Adjust your preferences");
        settingsButton.setOnAction(e -> showSettingsScreen());
        
        Button helpButton = createMenuButton("Help & Support", "Get help when you need it");
        helpButton.setOnAction(e -> showHelpScreen());
        
        menuBox.getChildren().addAll(menuTitle, formButton, emailButton, settingsButton, helpButton);
        
        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.TOP_LEFT);
        Button backButton = new Button("← Back");
        backButton.setOnAction(e -> showWelcomeScreen());
        headerBox.getChildren().add(backButton);
        
        mainLayout.getChildren().addAll(headerBox, menuBox);
    }
    
    private Button createMenuButton(String text, String description) {
        VBox buttonContent = new VBox(5);
        Label buttonText = new Label(text);
        buttonText.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label buttonDesc = new Label(description);
        buttonDesc.setStyle("-fx-font-size: 12px; -fx-text-fill: #7f8c8d;");
        buttonContent.getChildren().addAll(buttonText, buttonDesc);
        buttonContent.setAlignment(Pos.CENTER);
        
        Button button = new Button();
        button.setGraphic(buttonContent);
        button.setStyle("-fx-padding: 20px; -fx-background-color: white; -fx-border-color: #bdc3c7; -fx-border-width: 2px;");
        button.setPrefWidth(400);
        
        button.setOnMouseEntered(e -> button.setStyle("-fx-padding: 20px; -fx-background-color: #ecf0f1; -fx-border-color: #3498db; -fx-border-width: 2px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-padding: 20px; -fx-background-color: white; -fx-border-color: #bdc3c7; -fx-border-width: 2px;"));
        
        return button;
    }
    
    private void showFormScreen() {
        mainLayout.getChildren().clear();
        
        Label title = new Label("Simple Form");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        VBox formBox = new VBox(15);
        formBox.setPadding(new Insets(20));
        formBox.setMaxWidth(500);
        formBox.setStyle("-fx-background-color: white; -fx-padding: 30px; -fx-border-radius: 5px;");
        
        // Large, easy-to-read form fields
        Label nameLabel = new Label("Your Name:");
        nameLabel.setStyle("-fx-font-size: 18px;");
        TextField nameField = new TextField();
        nameField.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        nameField.setPromptText("Enter your full name");
        
        Label emailLabel = new Label("Your Email:");
        emailLabel.setStyle("-fx-font-size: 18px;");
        TextField emailField = new TextField();
        emailField.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        emailField.setPromptText("your.email@example.com");
        
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setStyle("-fx-font-size: 18px;");
        TextField phoneField = new TextField();
        phoneField.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        phoneField.setPromptText("Enter your phone number");
        
        Label messageLabel = new Label("Your Message:");
        messageLabel.setStyle("-fx-font-size: 18px;");
        TextArea messageArea = new TextArea();
        messageArea.setStyle("-fx-font-size: 18px;");
        messageArea.setPromptText("Type your message here...");
        messageArea.setPrefRowCount(5);
        
        Button submitButton = new Button("Submit Form");
        submitButton.setStyle("-fx-font-size: 18px; -fx-padding: 15px 40px; -fx-background-color: #27ae60; -fx-text-fill: white;");
        submitButton.setOnAction(e -> {
            if (validateForm(nameField, emailField, phoneField)) {
                showSuccessMessage("Form submitted successfully!");
                // In real app, this would save to database
            }
        });
        
        Button backButton = new Button("← Back to Menu");
        backButton.setOnAction(e -> showMainMenu());
        
        formBox.getChildren().addAll(
            title, nameLabel, nameField, emailLabel, emailField,
            phoneLabel, phoneField, messageLabel, messageArea,
            submitButton, backButton
        );
        
        mainLayout.getChildren().add(formBox);
    }
    
    private boolean validateForm(TextField name, TextField email, TextField phone) {
        if (name.getText().trim().isEmpty()) {
            showErrorMessage("Please enter your name");
            return false;
        }
        if (email.getText().trim().isEmpty() || !email.getText().contains("@")) {
            showErrorMessage("Please enter a valid email address");
            return false;
        }
        if (phone.getText().trim().isEmpty()) {
            showErrorMessage("Please enter your phone number");
            return false;
        }
        return true;
    }
    
    private void showEmailScreen() {
        mainLayout.getChildren().clear();
        
        Label title = new Label("Send an Email");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        VBox emailBox = new VBox(15);
        emailBox.setPadding(new Insets(20));
        emailBox.setMaxWidth(500);
        emailBox.setStyle("-fx-background-color: white; -fx-padding: 30px;");
        
        Label toLabel = new Label("To:");
        toLabel.setStyle("-fx-font-size: 18px;");
        TextField toField = new TextField();
        toField.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        
        Label subjectLabel = new Label("Subject:");
        subjectLabel.setStyle("-fx-font-size: 18px;");
        TextField subjectField = new TextField();
        subjectField.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        
        Label messageLabel = new Label("Message:");
        messageLabel.setStyle("-fx-font-size: 18px;");
        TextArea messageArea = new TextArea();
        messageArea.setStyle("-fx-font-size: 18px;");
        messageArea.setPrefRowCount(8);
        
        Button sendButton = new Button("Send Email");
        sendButton.setStyle("-fx-font-size: 18px; -fx-padding: 15px 40px; -fx-background-color: #3498db; -fx-text-fill: white;");
        sendButton.setOnAction(e -> showSuccessMessage("Email sent successfully!"));
        
        Button backButton = new Button("← Back to Menu");
        backButton.setOnAction(e -> showMainMenu());
        
        emailBox.getChildren().addAll(
            title, toLabel, toField, subjectLabel, subjectField,
            messageLabel, messageArea, sendButton, backButton
        );
        
        mainLayout.getChildren().add(emailBox);
    }
    
    private void showSettingsScreen() {
        mainLayout.getChildren().clear();
        
        Label title = new Label("Settings");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        VBox settingsBox = new VBox(20);
        settingsBox.setPadding(new Insets(20));
        settingsBox.setMaxWidth(500);
        settingsBox.setStyle("-fx-background-color: white; -fx-padding: 30px;");
        
        Label fontSizeLabel = new Label("Font Size:");
        fontSizeLabel.setStyle("-fx-font-size: 18px;");
        ComboBox<String> fontSizeCombo = new ComboBox<>();
        fontSizeCombo.getItems().addAll("Small", "Medium", "Large", "Extra Large");
        fontSizeCombo.setValue("Large");
        fontSizeCombo.setStyle("-fx-font-size: 16px;");
        
        CheckBox soundCheck = new CheckBox("Enable Sound");
        soundCheck.setStyle("-fx-font-size: 18px;");
        
        CheckBox notificationsCheck = new CheckBox("Enable Notifications");
        notificationsCheck.setStyle("-fx-font-size: 18px;");
        notificationsCheck.setSelected(true);
        
        Button saveButton = new Button("Save Settings");
        saveButton.setStyle("-fx-font-size: 18px; -fx-padding: 15px 40px; -fx-background-color: #27ae60; -fx-text-fill: white;");
        saveButton.setOnAction(e -> showSuccessMessage("Settings saved!"));
        
        Button backButton = new Button("← Back to Menu");
        backButton.setOnAction(e -> showMainMenu());
        
        settingsBox.getChildren().addAll(
            title, fontSizeLabel, fontSizeCombo, soundCheck,
            notificationsCheck, saveButton, backButton
        );
        
        mainLayout.getChildren().add(settingsBox);
    }
    
    private void showHelpScreen() {
        mainLayout.getChildren().clear();
        
        Label title = new Label("Help & Support");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        VBox helpBox = new VBox(15);
        helpBox.setPadding(new Insets(20));
        helpBox.setMaxWidth(600);
        helpBox.setStyle("-fx-background-color: white; -fx-padding: 30px;");
        
        Label helpText = new Label(
            "Need help? We're here for you!\n\n" +
            "• Click on any menu item to get started\n" +
            "• Forms are designed to be easy to fill out\n" +
            "• Large buttons and text make everything simple\n" +
            "• If you get stuck, click the Back button\n\n" +
            "For additional support, please contact:\n" +
            "Email: support@simpletech.com\n" +
            "Phone: 1-800-HELP-NOW"
        );
        helpText.setStyle("-fx-font-size: 18px; -fx-line-spacing: 5px;");
        helpText.setWrapText(true);
        
        Button backButton = new Button("← Back to Menu");
        backButton.setOnAction(e -> showMainMenu());
        
        helpBox.getChildren().addAll(title, helpText, backButton);
        
        mainLayout.getChildren().add(helpBox);
    }
    
    private void showSuccessMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

