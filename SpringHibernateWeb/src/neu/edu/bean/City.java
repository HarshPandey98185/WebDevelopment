package neu.edu.bean;

public class City {

	public enum cityLocation{
		Melbourne("-37.8136","144.9631"),Tokyo("35.6895","139.6917"),Delhi("28.7041","77.1025");
		
		private final String lat;
		private final String longi;
		
		private cityLocation(String lat, String longi) {
			this.lat = lat;
			this.longi = longi;
		}

		public String getLat() {
			return lat;
		}

		public String getLongi() {
			return longi;
		}

	
		@Override
		  public String toString() {
		    switch(this) {
		      case Melbourne: return "Melbourne";
		      case Tokyo: return "Tokyo";
		      case Delhi: return "Delhi";
		     
		      default: throw new IllegalArgumentException();
		    }
		
		
	}
	
 
	}
}
	
	
	
	

