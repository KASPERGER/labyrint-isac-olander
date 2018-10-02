package labyrint;

import java.io.File;

import Blocks.Block;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class labyrint extends Application {

	int count = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Map map = MapInterpreter.interpretMap(new File("map.txt"));
		
		MapSolver solvish = new MapSolver(map.getStartX(), map.getStartY(), map);

		Scene scene = new Scene(map, map.getWidth(), map.getHeight());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		

	
	new AnimationTimer(){
		
		public void handle(long now){
			
			if ( count < solvish.path.size()){
				
				map.getChildren().add(solvish.path.get(count));
				count++;
			}
			
			else{ System.out.println(solvish.path.size());
			this.stop();
			}
			
			
		}
		
		
	}.start();
	
}
	
	
	

	public static void main(String[] args) {
		launch();
	}

}
