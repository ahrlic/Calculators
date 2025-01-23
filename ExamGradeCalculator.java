
package activity5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import simpleIO.Console;

public class ExamGradeCalculator extends Application {
	
	static final int GAP = 15;
	static final int MEDIUM_FONT = 18;
	static final int SMALL_FONT = 12;
	
	//UI elements for Input/Output
	TextField txtTermMark, txtExamValue, txtDesiredGrade;
	Label lblResult; 
	
	@Override
	public void start(Stage myStage) throws Exception {
	
	VBox root = new VBox(GAP);
	root.setPadding(new Insets(GAP, GAP, GAP, GAP));
	
	Label lblInstructions = new Label(" Want to know what mark you need on your exam to obtain a certain grade?" + "\nEnter the required information: ");
	
	lblInstructions.setFont(Font.font(MEDIUM_FONT));
	root.getChildren().add(lblInstructions);
	
	Label lblTermMark = new Label("Grade before the exam: ");
	lblTermMark.setFont(Font.font(SMALL_FONT));
	txtTermMark = new TextField();
	HBox hbxTermMark = new HBox(GAP, lblTermMark, txtTermMark);
	root.getChildren().add(hbxTermMark);
	
	Label lblExamValue = new Label("Value of exam (%): ");
	lblExamValue.setFont(Font.font(SMALL_FONT));
	txtExamValue = new TextField();
	HBox hbxExamValue = new HBox(GAP, lblExamValue, txtExamValue);
	root.getChildren().add(hbxExamValue);
	
	Label lblDesiredGrade = new Label("Desired final grade: ");
	lblDesiredGrade.setFont(Font.font(SMALL_FONT));
	txtDesiredGrade = new TextField();
	HBox hbxDesiredGrade = new HBox(GAP, lblDesiredGrade, txtDesiredGrade);
	root.getChildren().add(hbxDesiredGrade);
	
	Button btnCalculate = new Button("Calculate!");
	root.getChildren().add(btnCalculate);
	
	lblResult = new Label();
	lblResult.setFont(Font.font(MEDIUM_FONT));
	root.getChildren().add(lblResult);
	
	btnCalculate.setOnAction(event -> calculateGrade());
	Scene scene = new Scene(root);
	
	myStage.setTitle("Exam Grade Calculator");
	myStage.setScene(scene);
	myStage.show();
	
	}

	
	private void calculateGrade() {
		//Local Variables
		int termMark, examValue, desiredGrade;
		double result;
		
		//Input
		try { //quick error-checking to ensure all text boxes contain number.
			String text = txtTermMark.getText();
			termMark = Integer.parseInt(text);
			
			examValue = Integer.parseInt(txtExamValue.getText());
			desiredGrade = Integer.parseInt(txtDesiredGrade.getText());
		} catch (NumberFormatException e) {
			lblResult.setText("Invalid entry");
			return;
		}
		
		//Processing
		result = termMark + (desiredGrade - termMark) / examValue / 100.0;
	
		//Output
		lblResult.setText("You must get " + Console.roundDouble(result, 2) + "% on your exam!");

}

	

	public static void main(String[] args) {
		launch(args);

	}

}

