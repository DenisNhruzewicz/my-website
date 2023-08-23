import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class InteractiveWebsiteApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a WebView to display HTML content
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Create interactive buttons
        Button button1 = new Button("Button 1");
        button1.setOnAction(event -> webEngine.executeScript("document.getElementById('output').innerHTML = 'Button 1 Clicked';"));

        Button button2 = new Button("Button 2");
        button2.setOnAction(event -> webEngine.executeScript("document.getElementById('output').innerHTML = 'Button 2 Clicked';"));

        // Create a VBox layout to hold buttons and WebView
        VBox root = new VBox(button1, button2, webView);

        // Load HTML content into the WebView
        String htmlContent = "<html><body><h1>Interactive Buttons Example</h1><p>Click a button to see the output:</p><p id='output'></p></body></html>";
        webEngine.loadContent(htmlContent);

        // Create a Scene and add it to the Stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Interactive Website Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
