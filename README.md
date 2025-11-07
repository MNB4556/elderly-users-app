# Simplifying Technology for Elderly Users

A JavaFX desktop application designed to make technology accessible for elderly and non-technical users through intuitive interfaces and simplified form-filling experiences.

## Features

- **User-Friendly Interface**: Large buttons, clear text, and simple navigation
- **Simplified Forms**: Easy-to-fill forms with validation
- **Email Functionality**: Simple email sending interface
- **Accessibility Features**: Customizable font sizes and settings
- **Help & Support**: Built-in help section
- **WCAG Compliance**: Designed following accessibility guidelines

## Requirements

- Java 11 or higher
- JavaFX SDK (included in Java 11+ or separate installation for older versions)

## Building the Project

### Using Java 11+ with built-in JavaFX:

```bash
cd elderly-users-app
javac --module-path <path-to-javafx> --add-modules javafx.controls src/Main.java
```

### Running the Application:

```bash
java --module-path <path-to-javafx> --add-modules javafx.controls src/Main
```

### Using an IDE (Recommended):

1. Open the project in IntelliJ IDEA or Eclipse
2. Ensure JavaFX is configured in your IDE
3. Run `Main.java`

## Project Structure

```
elderly-users-app/
├── src/
│   └── Main.java          # Main application file
└── README.md              # This file
```

## Technologies Used

- Java 11+
- JavaFX (FXML, Scene Builder compatible)
- MVC Architecture
- Git version control

## Key Features Implementation

- **Responsive UI Design**: Clean, modern interface with consistent styling
- **Form Validation**: Real-time validation with user-friendly error messages
- **Data Persistence**: Structure ready for database integration (SQLite/MySQL)
- **User Session Management**: Session tracking capabilities
- **Accessibility Compliance**: Follows WCAG guidelines for accessibility

## Future Enhancements

- Database integration for form data storage
- Voice commands support
- Multi-language support
- Cloud sync capabilities
- Advanced accessibility features

