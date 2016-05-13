package org.codehaus.swizzle.jira;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mirko on 14.05.16.
 */
public interface Jira {
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
     * List<{@link Comment}>: Returns all comments associated with the issue
     */
    List getComments(String issueKey);

    List getComments(Issue issue);

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

    Issue getIssue(String issueKey);

    List<Issue> getIssuesFromFilter(Filter filter) throws Exception;

    List<Issue> getIssuesFromFilter(String filterName) throws Exception;

    List<Issue> getIssuesFromFilter(int filterId) throws Exception;

    List<Issue> getIssuesFromTextSearch(String searchTerms) throws Exception;

    List<Issue> getIssuesFromTextSearchWithProject(List projectKeys, String searchTerms, int maxNumResults) throws Exception;

    List<IssueType> getIssueTypes();

    IssueType getIssueType(String name);

    IssueType getIssueType(int id);

    // New for JIRA 4.0
    List getIssueTypesForProject(int projectId);

    List getIssueTypesForProject(String projectKey);

    /**
     * List<{@link Priority}>: Returns all priorities in the system
     */
    List<Priority> getPriorities();

    Priority getPriority(String name);

    Priority getPriority(int id);

    /**
     * List<{@link Project}>: Returns a list of projects available to the user
     */
    List<Project> getProjects();

    Project getProject(String key);

    Project getProject(int id);

    /**
     * List<{@link Resolution}>: Returns all resolutions in the system
     */
    List<Resolution> getResolutions();

    Resolution getResolution(String name);

    Resolution getResolution(int id);

    /**
     * List<{@link Status}>: Returns all statuses in the system
     */
    List<Status> getStatuses();

    Status getStatus(String name);

    Status getStatus(int id);

    /**
     * List<{@link Filter}>: Gets all saved filters available for the currently logged in user
     */
    List<Filter> getSavedFilters();

    Filter getSavedFilter(String name);

    Filter getSavedFilter(int id);

    /**
     * Returns the Server information such as baseUrl, version, edition, buildDate, buildNumber.
     */
    ServerInfo getServerInfo();

    /**
     * List<{@link IssueType}>: Returns all visible subtask issue types in the system
     *
     * @return list of {@link IssueType}
     */
    List<IssueType> getSubTaskIssueTypes();

    IssueType getSubTaskIssueType(String name);

    IssueType getSubTaskIssueType(int id);

    /**
     * Returns a user's information given a username
     */
    User getUser(String username);

    /**
     * List<{@link Component}>: Returns all components available in the specified project
     */
    List<Component> getComponents(String projectKey);

    List<Component> getComponents(Project project);

    Component getComponent(String projectKey, String name);

    Component getComponent(Project project, String name);

    Component getComponent(String projectKey, int id);

    Component getComponent(Project project, int id);

    /**
     * List<{@link Version}>: Returns all versions available in the specified project
     */
    List<Version> getVersions(String projectKey);

    List<Version> getVersions(Project project);

    Version getVersion(String projectKey, String name);

    Version getVersion(Project project, String name);

    Version getVersion(String projectKey, int id);

    Version getVersion(Project project, int id);

    List getFavoriteFilters();

    Issue fill(Issue issue);

}
