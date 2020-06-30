package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class service  extends Service<ObservableList<String>> {

	@Override
	protected Task<ObservableList<String>> createTask() {
		// TODO Auto-generated method stub
		
		 return new Task<ObservableList<String>>() {

				@Override
				protected ObservableList<String> call() throws Exception {
					// TODO Auto-generated method stub
				       
					String[] strname= {"nikunj","bisht","docker","java","Python","Node","Kotlin","Go"};
					
					
			//		Thread.sleep(2000);
					ObservableList<String> ol=FXCollections.observableArrayList();
					
					for(int i=0;i<strname.length;i++) {
						ol.add(strname[i]);
						updateMessage("Completed "+(i+1)*10+" %");
						
						updateProgress(i+1,8);   // this update the progress bar 
						Thread.sleep(200);
					}
					

					return ol;
				}
				
		 
			 };
		
		
		
	}

}
