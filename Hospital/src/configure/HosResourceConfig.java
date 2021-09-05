package configure;

import org.glassfish.jersey.server.ResourceConfig;
import authentication.AuthenticationFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import configure.GsonMessageConfig;

public class HosResourceConfig extends ResourceConfig{
	  public HosResourceConfig() {
		    packages("configure");
		    register(LoggingFilter.class);
		    register(GsonMessageConfig.class);
		    register(AuthenticationFilter.class);
		  }
}
 