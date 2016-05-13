package org.codehaus.swizzle.jira;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mirko on 14.05.16.
 */
public interface Jira extends JiraReadOnly {
    /**
     * Valid schemes are "issue", "project", "voters", and "attachments" "issues" is enabled by default
     *
     * @param scheme
     * @param enabled
     */
    void autofill(String scheme, boolean enabled);

    /**
     * Logs the user into JIRA
     */
    void login(String username, String password) throws Exception;

    /**
     * remove this token from the list of logged in tokens.
     */
    boolean logout() throws Exception;

    /**
     * Adds a comment to an issue TODO: If someone adds a comment to an issue, we should account for that in our caching
     */
    boolean addComment(String issueKey, String comment) throws Exception;

    /**
     * Creates an issue in JIRA TODO: If someone creates an issue, we should account for that in our caching
     */
    Issue createIssue(Issue issue) throws Exception;

    /**
     * Updates an issue in JIRA from a HashMap object TODO: If someone updates an issue, we should account for that in our caching
     */
    Issue updateIssue(String issueKey, Issue issue) throws Exception;

    Issue fill(Issue issue);

}
