public class TrajectoryLauncher {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			TrajectoryModel model = new TrajectoryModel();
			TrajectoryView view = new TrajectoryView();
			new TrajectoryController(view, model);
			
		}

	}