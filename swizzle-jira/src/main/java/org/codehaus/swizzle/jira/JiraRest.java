package org.codehaus.swizzle.jira;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ning.http.client.AsyncHttpClient;
import org.json.JSONObject;

import java.net.URI;
import java.util.List;

/**
 * Created by mirko on 14.05.16.
 */
public class JiraRest implements Jira {

    private final URI uri;
    private final AsyncHttpClient client = new AsyncHttpClient();

    public JiraRest(String url) {
        uri = URI.create(url).resolve("rest/api/2/");
    }

    @Override
    public void autofill(String scheme, boolean enabled) {

    }

    @Override
    public void login(String username, String password) throws Exception {

    }

    @Override
    public boolean logout() throws Exception {
        return false;
    }

    @Override
    public boolean addComment(String issueKey, String comment) throws Exception {
        return false;
    }

    @Override
    public Issue createIssue(Issue issue) throws Exception {
        return null;
    }

    @Override
    public Issue updateIssue(String issueKey, Issue issue) throws Exception {
        return null;
    }

    @Override
    public Issue fill(Issue issue) {
        return null;
    }

    @Override
    public List getComments(String issueKey) {
        return null;
    }

    @Override
    public List getComments(Issue issue) {
        return null;
    }

    @Override
    public Issue getIssue(String issueKey) {
        try {
            final JSONObject jsonObject = Unirest.get(uri.resolve("issue/" + issueKey).toString()).asJson().getBody().getObject();
            return new Issue(new JSONObjectToMap(jsonObject).invoke());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Issue> getIssuesFromFilter(Filter filter) throws Exception {
        return null;
    }

    @Override
    public List<Issue> getIssuesFromFilter(String filterName) throws Exception {
        return null;
    }

    @Override
    public List<Issue> getIssuesFromFilter(int filterId) throws Exception {
        return null;
    }

    @Override
    public List<Issue> getIssuesFromTextSearch(String searchTerms) throws Exception {
        return null;
    }

    @Override
    public List<Issue> getIssuesFromTextSearchWithProject(List projectKeys, String searchTerms, int maxNumResults) throws Exception {
        return null;
    }

    @Override
    public List<IssueType> getIssueTypes() {
        return null;
    }

    @Override
    public IssueType getIssueType(String name) {
        return null;
    }

    @Override
    public IssueType getIssueType(int id) {
        return null;
    }

    @Override
    public List getIssueTypesForProject(int projectId) {
        return null;
    }

    @Override
    public List getIssueTypesForProject(String projectKey) {
        return null;
    }

    @Override
    public List<Priority> getPriorities() {
        return null;
    }

    @Override
    public Priority getPriority(String name) {
        return null;
    }

    @Override
    public Priority getPriority(int id) {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public Project getProject(String key) {
        return null;
    }

    @Override
    public Project getProject(int id) {
        return null;
    }

    @Override
    public List<Resolution> getResolutions() {
        return null;
    }

    @Override
    public Resolution getResolution(String name) {
        return null;
    }

    @Override
    public Resolution getResolution(int id) {
        return null;
    }

    @Override
    public List<Status> getStatuses() {
        return null;
    }

    @Override
    public Status getStatus(String name) {
        return null;
    }

    @Override
    public Status getStatus(int id) {
        return null;
    }

    @Override
    public List<Filter> getSavedFilters() {
        return null;
    }

    @Override
    public Filter getSavedFilter(String name) {
        return null;
    }

    @Override
    public Filter getSavedFilter(int id) {
        return null;
    }

    @Override
    public ServerInfo getServerInfo() {
        final URI serverInfoUri = uri.resolve("serverInfo");
        System.out.println(serverInfoUri);
        try {
            final HttpResponse<JsonNode> response = Unirest.get(serverInfoUri.toString()).asJson();
            final JsonNode node = response.getBody();
            final JSONObject jsonObject = node.getObject();
            return new ServerInfo(new JSONObjectToMap(jsonObject).invoke());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<IssueType> getSubTaskIssueTypes() {
        return null;
    }

    @Override
    public IssueType getSubTaskIssueType(String name) {
        return null;
    }

    @Override
    public IssueType getSubTaskIssueType(int id) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<Component> getComponents(String projectKey) {
        return null;
    }

    @Override
    public List<Component> getComponents(Project project) {
        return null;
    }

    @Override
    public Component getComponent(String projectKey, String name) {
        return null;
    }

    @Override
    public Component getComponent(Project project, String name) {
        return null;
    }

    @Override
    public Component getComponent(String projectKey, int id) {
        return null;
    }

    @Override
    public Component getComponent(Project project, int id) {
        return null;
    }

    @Override
    public List<Version> getVersions(String projectKey) {
        return null;
    }

    @Override
    public List<Version> getVersions(Project project) {
        return null;
    }

    @Override
    public Version getVersion(String projectKey, String name) {
        return null;
    }

    @Override
    public Version getVersion(Project project, String name) {
        return null;
    }

    @Override
    public Version getVersion(String projectKey, int id) {
        return null;
    }

    @Override
    public Version getVersion(Project project, int id) {
        return null;
    }

    @Override
    public List getFavoriteFilters() {
        return null;
    }

}
