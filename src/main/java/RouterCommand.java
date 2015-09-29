import net.sourceforge.argparse4j.inf.Namespace;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;

import io.dropwizard.Application;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.setup.Environment;

/**
 * Created by pascalou on 01/09/15.
 */
public class RouterCommand extends EnvironmentCommand<DPConfig> {

    protected RouterCommand(Application<DPConfig> service, String name, String description) {
        super(service, name, description);
        System.out.println("je suis dans le router");
    }

    @Override
    protected void run(Environment environment, Namespace namespace, DPConfig dpConfig) throws Exception {
        System.out.println("je suis dans le router");
        environment.jersey().register(new DPRouterResource());

        final Server server = dpConfig.getServerFactory().build(environment);
        try {
            server.addLifeCycleListener(new LifeCycleListener());
            cleanupAsynchronously();
            server.start();
        } catch (Exception e) {
            server.stop();
            cleanup();
            throw e;
        }

    }

    private class LifeCycleListener extends AbstractLifeCycle.AbstractLifeCycleListener {
        @Override
        public void lifeCycleStopped(LifeCycle event) {
            cleanup();
        }
    }
}
