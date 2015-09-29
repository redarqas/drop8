import io.dropwizard.Application;
import io.dropwizard.cli.Cli;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.util.JarLocation;

/**
 * Created by pascalou on 01/09/15.
 */
public class DPApplication extends Application<DPConfig> {

    public static void main(String[] args) throws Exception {
        String command = "listener";

        System.out.println("je passe dans le main");
        String[] args2 = new String[1];
        args2[0] = command;
        new DPApplication().overidedRun(args2);
    }

    @Override
    public String getName() {
        return "a test application";
    }

    @Override
    public void initialize(Bootstrap<DPConfig> bootstrap) {
        System.out.println("je passe dans l'init");
    }

    public void overidedRun(String[] arguments) throws Exception {
        final Bootstrap<DPConfig> bootstrap = new Bootstrap<DPConfig>(this);
        bootstrap.addCommand(new RouterCommand(this, "router", "un beau router"));
        bootstrap.addCommand(new ListenerCommand(this, "listener", "un beau listener"));

        final Cli cli = new Cli(new JarLocation(this.getClass()), bootstrap, System.out, System.err);
        if (!cli.run(arguments)) {
            // only exit if there's an error running the command
            System.exit(1);
        }
    }

    @Override
    public void run(DPConfig dpConfig, Environment environment) throws Exception {
        System.out.println("je passe dans le run");
    }
}
