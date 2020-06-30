package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
 
	 private Task<ObservableList<String>> task;
	 @FXML
	 private Button btn1;
	 @FXML
	private ListView list;
	 
	 @FXML
	 private ProgressBar progress;
	 @FXML
	 private Label label1;
	 
	 private Service<ObservableList<String>> service;
	 
	 public void initialize() {
	
		 service=new service();        ///// We used service class to manage processess and added task to service

		 Thread thread=new Thread() {          //Thread Interface 

				@Override
				public void run() {                            
					// TODO Auto-generated method stub
				try {
				
					Thread.sleep(2000);

					
				Platform.runLater(new Runnable() {  // background and ui thread dont run together so we need platform.runlater 

					@Override
					public void run() {
						// TODO Auto-generated method stub
						          
						btn1.setText("press fast");
					}
					
				});
				} catch (Exception e2) {
					// TODO: handle exception
				}	
				}
				
			};
		 thread.start();
		
	service.setOnRunning(new EventHandler<WorkerStateEvent>() {

		@Override
		public void handle(WorkerStateEvent arg0) {
			// TODO Auto-generated method stub
			    
			     progress.setVisible(true);
			     label1.setVisible(true);
			 
			 
		}
		
	});	  
		  
		  
		 
	service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

		@Override
		public void handle(WorkerStateEvent arg0) {
			// TODO Auto-generated method stub
			
			 progress.setVisible(false);
		label1.setVisible(false);	 
		}
		
		
	});
progress.progressProperty().bind(service.progressProperty());  // the progressbar will increment when the entry will be added to task(part of data binding) 
label1.textProperty().bind(service.messageProperty());        // this binds label with tasks 
list.itemsProperty().bind(service.valueProperty());			



// binds the progressbar with task(ObservableList)  *********  
				
	 }

	 @FXML
	 public void displaydataonclick() {
		 
 	//	service.start();
  		
         if(service.getState()==Service.State.SUCCEEDED) {
        	 service.reset();
        	 service.start();
         }
         else {
        	 service.start();
         }
		  
	 }
	 
	 
	  
}
