package com.gk;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class JavaFX_Bank_Project extends Application {
//scene1-Registration,scene2->Login,scene3->form
Scene scene1, scene2,scene3;
String name1,name2,email,pwd1,pwd2,mobileno;
   
@Override
public void start(Stage primaryStage)   {
        
primaryStage.setTitle("Bank of MyBank");

//scene1-Registration
GridPane gridPane = new GridPane();

// Position the pane at the center of the screen, both vertically and horizontally
gridPane.setAlignment(Pos.CENTER);

// Set a padding of 40px on each side
gridPane.setPadding(new Insets(40, 40, 40, 40));

// Set the horizontal gap between columns
gridPane.setHgap(20);

// Set the vertical gap between rows
gridPane.setVgap(20);


Image image = new Image("https://www.kreativwebsolutions.com/images/keyaccount.png",100,100,false,false);
//Creating the image view
ImageView imageView = new ImageView();

//Setting image to the image view
imageView.setImage(image);

gridPane.add(new ImageView(image),1,0,2,1);

Label headerLabel = new Label("Registration Form");
headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
GridPane.setHalignment(headerLabel, HPos.CENTER);
GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
gridPane.add(headerLabel,0,1,2,1);

// Add Name Label
Label nameLabel = new Label("User Name");
gridPane.add(nameLabel, 0,2);

// Add Name Text Field
TextField nameField = new TextField();
name1=nameField.getText();
nameField.setPrefHeight(40);
gridPane.add(nameField, 1,2);


// Add Email Label
Label emailLabel = new Label("Email ID");
gridPane.add(emailLabel, 0,3);

// Add Email Text Field
TextField emailField = new TextField();
email=emailField.getText();
emailField.setPrefHeight(40);
gridPane.add(emailField, 1, 3);

// Add Password Label
Label passwordLabel = new Label("Password");
gridPane.add(passwordLabel, 0, 4);

// Add Password Field
PasswordField passwordField = new PasswordField();
pwd1=passwordField.getText();
passwordField.setPrefHeight(40);
gridPane.add(passwordField, 1, 4);

//Add mobile Label
Label mobile = new Label("Mobile No");
gridPane.add(mobile, 0, 5);

//Add mobile Text Field
TextField mobileField = new TextField();
mobileno=mobileField.getText();
mobileField.setPrefHeight(40);
gridPane.add(mobileField, 1, 5);

//Add submit button
Button submitButton= new Button("Submit");
gridPane.add(submitButton, 1,7,2,1);
submitButton.setStyle("-fx-background-color: Gray; -fx-text-fill: black;"); 

submitButton.setPrefHeight(40);
//submitButton.setDefaultButton(true);
submitButton.setPrefWidth(100);
GridPane.setHalignment(submitButton, HPos.LEFT);
submitButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        if(nameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please Enter your username");
            return;
        }else 
        if(emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please Enter your email id");
            return;
        }else
        if(!emailField.getText().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please Enter valid email id");
            return;
        }else
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please Enter a password");
            return;
        }else
        if(!passwordField.getText().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}")){
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) ");
            return;
        } 
        if(mobileField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please enter a mobile no");
            return;
        }else
        if(!mobileField.getText().matches("^[2-9]{1}[0-9]{9}$")) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please enter a valid mobile no");
            return;
        }
        else {
        primaryStage.setScene(scene2);
        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), 
        "Registration Successful!", "Welcome " + nameField.getText());
        }
        
        }
});

VBox layout1 = new VBox(20);     
layout1.getChildren().addAll(gridPane);
layout1.setStyle("-fx-background-color: Gainsboro;"); 

scene1= new Scene(layout1, 550, 700);

//Scene 2->Login

GridPane gridPane1 = new GridPane();

//Position the pane at the center of the screen, both vertically and horizontally
gridPane1.setAlignment(Pos.CENTER);

//Set a padding of 40px on each side
gridPane1.setPadding(new Insets(40, 40, 40, 40));

//Set the horizontal gap between columns
gridPane1.setHgap(20);

//Set the vertical gap between rows
gridPane1.setVgap(20);


Image image1 = new Image("https://www.kreativwebsolutions.com/images/keyaccount.png",100,100,false,false);
//Creating the image view
ImageView imageView1 = new ImageView();
//Setting image to the image view
imageView1.setImage(image1);
gridPane1.add(new ImageView(image1),1,0,2,1);

Label headerLabel1 = new Label("Login Form");
headerLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
gridPane1.add(headerLabel1, 0,1,2,1);
GridPane.setHalignment(headerLabel1, HPos.CENTER);
GridPane.setMargin(headerLabel1, new Insets(20, 0,20,0));

//Add Name Label
Label nameLabel1 = new Label("User Name");
gridPane1.add(nameLabel1, 0,2);

//Add Name Text Field
TextField nameField1 = new TextField();
name2=nameField1.getText();
nameField1.setPrefHeight(40);
gridPane1.add(nameField1, 1,2);


//Add Password Label
Label passwordLabel1 = new Label("Password");
gridPane1.add(passwordLabel1, 0, 3);

//Add Password Text Field
PasswordField passwordField1 = new PasswordField();
pwd2=passwordField.getText();
passwordField1.setPrefHeight(40);
gridPane1.add(passwordField1, 1, 3);

Button button2= new Button("Register");
button2.setPrefHeight(40);
button2.setDefaultButton(true);
button2.setPrefWidth(100);
GridPane.setHalignment(button2, HPos.LEFT);
button2.setStyle("-fx-background-color: Gray; -fx-text-fill: black;"); 

button2.setOnAction(e -> primaryStage.setScene(scene1));

Button button4= new Button("Submit");
button4.setPrefHeight(40);
button4.setDefaultButton(true);
button4.setPrefWidth(100);
GridPane.setHalignment(button4, HPos.RIGHT);
button4.setStyle("-fx-background-color: Gray; -fx-text-fill: black;"); 

gridPane1.add(button2,0,6,2,1);

gridPane1.add(button4,1,6,2,1);
button4.setOnAction(e -> {
	if(nameField1.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
        "Login Error!", "Please Enter your name");
        return;
    }else
     if(!nameField.getText().equals(nameField1.getText())) {
        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
        "Login Error!", "User not exist");
        return;
        }else 
     if(passwordField1.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
        "Login Error!", "Please Enter your password");
        return;
    }
    else
    if(nameField.getText().equals(nameField1.getText()) && !passwordField.getText().equals(passwordField1.getText())) {
    	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
    	"Login Error!", "Wrong password!!");
    	return;
    }
    else
	if(nameField.getText().equals(nameField1.getText()) && passwordField.getText().equals(passwordField1.getText())) {
		showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), 
		"Login Successful!", "Welcome " + nameField.getText());
		primaryStage.setScene(scene3);
		}
	else{
		primaryStage.setScene(scene2);
		
	}});
VBox layout2= new VBox(20);
layout2.getChildren().addAll(gridPane1);
layout2.setStyle("-fx-background-color: Gainsboro;"); 
scene2= new Scene(layout2,550,700);
        
//Scene 3->form

Label deposit=new Label("Deposit:");	
Label amount=new Label("Enter amount");
Label line=new Label("--------------------------------------------------");
Label line1=new Label("--------------------------------");
Label transfer=new Label("Transfer:");
Label payeename=new Label("Enter Payee Name");
Label amount1=new Label("Enter amount");
Label line2=new Label("--------------------------------------------------");
Label line3=new Label("--------------------------------");
Label userinfo=new Label("User Information:");
Label depositamount=new Label("");
Label transferamount=new Label("");
Label user_info=new Label("");
Label line4=new Label("--------------------------------------------------");
Label line5=new Label("--------------------------------");
Label transactionlist=new Label("Latest Transaction list:");
Label transaction_list=new Label("");

TextField tf1=new TextField("0");//deposit
TextField tf2=new TextField();
TextField tf3=new TextField("0");//transfer
Button depositbutton=new Button("Deposit");
depositbutton.setOnAction(value -> {
	if(tf1.getText().isEmpty()) {
		depositamount.setText("");
		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
    	        "Form Error!", "Enter Amount for deposit");
    	        return;
		}
	else {
		depositamount.setText("Amount "+tf1.getText()+" deposited to your account");
		
	}
});

Button transferbutton=new Button("Transfer");

transferbutton.setOnAction(value->
	{
	if(tf2.getText().isEmpty()){
	transferamount.setText("");
	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
	"Form Error!", "Enter Payeename for transfer");
	 return;
	}else
	if(tf3.getText().isEmpty()){
	transferamount.setText("");
	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
	"Form Error!", "Enter Amount for transfer");
	return;
	}else
	if(depositamount.getText().isEmpty()){
	transferamount.setText("");
	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
	"Form Error!", "Deposit some amount into your account first");
	return;
	}else
	if(Integer.parseInt(tf1.getText())<Integer.parseInt(tf3.getText())) {
	transferamount.setText("");	
	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
	"Form Error!", "You don't have enough amount to tranfer.Your balance is"+tf1.getText());
	return;
	}
	else{
		transferamount.setText("Amount "+tf3.getText()+" transferred to "+tf2.getText()+" from your account");
	}
});


int balance=0;
final int c=balance;
Button userbutton=new Button("See Info");
userbutton.setOnAction(value->{
	if(!depositamount.getText().isEmpty()) {
	if(!transferamount.getText().isEmpty()) {
	if(Integer.parseInt(tf1.getText())>Integer.parseInt(tf3.getText())) {
		if(tf2.getText().equals(nameField.getText())){
			user_info.setText("User name:"+nameField.getText()+"\nEmail:"+emailField.getText()+"\nMobile No:"+mobileField.getText()+"\nBalance:"+(c+Integer.parseInt(tf1.getText())));
		}else {
			user_info.setText("User name:"+nameField.getText()+"\nEmail:"+emailField.getText()+"\nMobile No:"+mobileField.getText()+"\nBalance:"+(c+Integer.parseInt(tf1.getText())-Integer.parseInt(tf3.getText())));}}
	else {
		user_info.setText("User name:"+nameField.getText()+"\nEmail:"+emailField.getText()+"\nMobile No:"+mobileField.getText()+"\nBalance:"+(c+Integer.parseInt(tf1.getText())));
	}
	
	}
	else {
		user_info.setText("User name:"+nameField.getText()+"\nEmail:"+emailField.getText()+"\nMobile No:"+mobileField.getText()+"\nBalance:"+(c+Integer.parseInt(tf1.getText())));
	}
	
	}
	
	else {
		user_info.setText("User name:"+nameField.getText()+"\nEmail:"+emailField.getText()+"\nMobile No:"+mobileField.getText()+"\nBalance:"+c);
		
	}
	
});

Button transactionbutton=new Button("See Info");
transactionbutton.setOnAction(value->{
if((!depositamount.getText().isEmpty()) && (!transferamount.getText().isEmpty())) 
{
transaction_list.setText("Deposit: "+depositamount.getText()+"\nTransfer: "+transferamount.getText());
}
else if((depositamount.getText().isEmpty()) && (!transferamount.getText().isEmpty())) 
{
transaction_list.setText("Transfer: "+transferamount.getText());
}
else if((!depositamount.getText().isEmpty()) && (transferamount.getText().isEmpty())) 
{
transaction_list.setText("Deposit: "+depositamount.getText());
}
else {
transaction_list.setText("");

}
});

GridPane root=new GridPane();

root.setAlignment(Pos.CENTER);
root.setHgap(10);
root.setVgap(10);
root.addRow(0, deposit);
root.addRow(1, amount,tf1);
root.addRow(2, depositamount);
root.addRow(3, depositbutton);
root.addRow(4, line,line1);
root.addRow(5, transfer);
root.addRow(6, payeename,tf2);
root.addRow(7, amount1,tf3);
root.addRow(8, transferamount);
root.addRow(9, transferbutton);
root.addRow(10, line2,line3);
root.addRow(11, userinfo);
root.addRow(12,user_info);
root.addRow(13,userbutton);
root.addRow(14, line4,line5);
root.addRow(15, transactionlist);
root.addRow(16, transaction_list);
root.addRow(17, transactionbutton);

Button button3= new Button("Logout");
root.addRow(18, button3);

button3.setPrefHeight(40);
button3.setDefaultButton(true);
button3.setPrefWidth(100);
GridPane.setHalignment(button3, HPos.RIGHT);
button3.setStyle("-fx-background-color: Gray; -fx-text-fill: black;"); 
button3.setOnAction(e -> primaryStage.setScene(scene2));
VBox layout3= new VBox(20);
layout3.getChildren().addAll(root);
layout3.setStyle("-fx-background-color: Gainsboro;"); 

scene3= new Scene(layout3,550,700);
        
primaryStage.setScene(scene1);
primaryStage.show();
}

private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}
public static void main(String[] args) {
launch(args);
}
    
}

