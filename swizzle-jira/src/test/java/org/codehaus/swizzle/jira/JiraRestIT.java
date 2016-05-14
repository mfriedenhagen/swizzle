package org.codehaus.swizzle.jira;

/**
 * Created by mirko on 14.05.16.
 */
public class JiraRestIT extends JiraIT {

    @Override
    protected Jira getJira() throws Exception {
        return new JiraRest("https://issues.apache.org/jira/");
    }
}
