package no.bekk.bekkopen.maven.extension;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.cli.ExecutionTimingExecutionListener;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.execution.RuntimeInformation;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "buildtime")
public class BuildTimeMavenExtension extends AbstractMavenLifecycleParticipant {

	@Requirement
	private Logger logger;

	@Requirement
	RuntimeInformation runtime;

	@Override
	public void afterProjectsRead(final MavenSession session) {

		logger.info("");
		logger.info("____        _ _     _ _______ _");
		logger.info("|  _ \\      (_) |   | |__   __(_)");
		logger.info("| |_) |_   _ _| | __| |  | |   _ _ __ ___   ___");
		logger.info("|  _ <| | | | | |/ _` |  | |  | | '_ ` _ \\ / _ \\");
		logger.info("| |_) | |_| | | | (_| |  | |  | | | | | | |  __/");
		logger.info("|____/ \\__,_|_|_|\\__,_|  |_|  |_|_| |_| |_|\\___|");
		logger.info("");

		session.getRequest().setExecutionListener(new ExecutionTimingExecutionListener(logger));

	}
}
