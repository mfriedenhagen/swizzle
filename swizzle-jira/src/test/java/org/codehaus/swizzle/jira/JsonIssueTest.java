package org.codehaus.swizzle.jira;

import com.mashape.unirest.http.JsonNode;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mirko on 14.05.16.
 */
public class JsonIssueTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);

    final InputStream stream = JsonIssueTest.class.getResourceAsStream("/issue.json");

    @After
    public void closeStream() throws IOException {
        stream.close();
    }

    @Test
    public void shouldLoadFromJson() throws IOException, ParseException {
        final JSONObject object = new JsonNode(IOUtils.toString(stream)).getObject();
        final Issue issue = new Issue(new JSONObjectToMap(object).invoke());
        assertEquals("MSHARED-490", issue.getKey());
        assertEquals(formatter.parse("2016-01-05T07:54:38.795+0000"), issue.getCreated());
        assertEquals("Plexus lookup test fails with Maven 3.1.0 or later", issue.getSummary());
        assertEquals("Issue.getType()", 6, issue.getType().getId());
        assertEquals("Issue.getEnvironment()", null, issue.getEnvironment());
        assertEquals("Issue.getStatus()", 6, issue.getStatus().getId());
        assertEquals("Issue.getUpdated()", formatter.parse("2016-03-27T16:32:36.839+0200") , issue.getUpdated());
        assertEquals("Issue.getId()", 12927202, issue.getId());

        assertTrue("Issue.getDescription()", issue.getDescription().startsWith("testShouldLookupInstanceDefaultRoleHint of"));
        assertEquals("Issue.getDuedate()", new Date(), issue.getDuedate());
        assertEquals("Issue.getReporter()", "mizdebsk", issue.getReporter().getName());
        assertEquals("Issue.getProject()", "MSHARED", issue.getProject().getKey());
        assertEquals("Issue.getResolution()", 5, issue.getResolution().getId());
        assertEquals("Issue.getVotes()", 0, issue.getVotes());
//        assertEquals("Issue.getAssignee()", null, issue.getAssignee());
//        assertEquals("Issue.getPriority()", 1, issue.getPriority().getId());
//        assertEquals("Issue.getLink() - " + issue.getLink(), "https://jira.codehaus.org/browse/SWIZZLE-1", issue.getLink());
//
//        assertEquals("Issue.getFixVersions().size()", 1, issue.getFixVersions().size());
//        assertTrue("FixVersion instance of Version", issue.getFixVersions().get(0) instanceof Version);
//        Version version = (Version) issue.getFixVersions().get(0);
//        assertEquals("Version.getName()", "Test Version", version.getName());
//        assertEquals("Version.getReleased()", false, version.getReleased());
//        assertEquals("Version.getArchived()", false, version.getArchived());
//        assertEquals("Version.getReleaseDate()", "Sun Aug 06 00:00:00 2006", formatter.format(version.getReleaseDate()));
//        assertEquals("Version.getSequence()", 5, version.getSequence());
//        assertEquals("Version.getId()", 12831, version.getId());
//
//        assertEquals("Issue.getAffectsVersions().size()", 1, issue.getAffectsVersions().size());
//        assertTrue("AffectsVersion instance of Version", issue.getAffectsVersions().get(0) instanceof Version);
//        version = (Version) issue.getAffectsVersions().get(0);
//        assertEquals("Version.getName()", "Test Version", version.getName());
//        assertEquals("Version.getReleased()", false, version.getReleased());
//        assertEquals("Version.getArchived()", false, version.getArchived());
//        assertEquals("Version.getReleaseDate()", "Sun Aug 06 00:00:00 2006", formatter.format(version.getReleaseDate()));
//        assertEquals("Version.getSequence()", 5, version.getSequence());
//        assertEquals("Version.getId()", 12831, version.getId());
//
//        assertEquals("Issue.getComponents().size()", 1, issue.getComponents().size());
//        assertTrue("Issue.getComponents instance of Component", issue.getComponents().get(0) instanceof Component);
//        Component component = (Component) issue.getComponents().get(0);
//        assertEquals("Component.getName()", "swizzle-jira", component.getName());
//        assertEquals("Component.getId()", 12312, component.getId());
//
//        Map data = issue.toMap();
//
//        assertEquals("issue.Created", "2006-08-04 20:05:13.157", data.get("created"));
//        assertEquals("issue.Summary", "Unit Test Summary", data.get("summary"));
//        assertEquals("issue.Type", "2", data.get("type"));
//        assertEquals("issue.Environment", "Unit Test Environment", data.get("environment"));
//        assertEquals("issue.Status", "6", data.get("status"));
//        assertEquals("issue.Updated", "2006-08-04 21:33:48.108", data.get("updated"));
//        assertEquals("issue.Id", "40099", data.get("id"));
//        assertEquals("issue.Key", "SWIZZLE-1", data.get("key"));
//        assertEquals("issue.Description", "Unit Test Description", data.get("description"));
//        assertEquals("issue.Duedate", "2006-08-06 00:00:00.0", data.get("duedate"));
//        assertEquals("issue.Reporter", "dblevins", data.get("reporter"));
//        assertEquals("issue.Project", "SWIZZLE", data.get("project"));
//        assertEquals("issue.Resolution", "1", data.get("resolution"));
//        assertEquals("issue.Votes", "1", data.get("votes"));
//        assertEquals("issue.Assignee", "dblevins", data.get("assignee"));
//        assertEquals("issue.Priority", "1", data.get("priority"));
//        assertEquals("issue.Link", null, data.get("link"));

    }
}
