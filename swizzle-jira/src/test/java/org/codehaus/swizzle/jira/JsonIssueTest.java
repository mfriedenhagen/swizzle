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
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mirko on 14.05.16.
 */
public class JsonIssueTest {

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
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
        assertEquals("Issue.getAssignee()", null, issue.getAssignee());
        assertEquals("Issue.getPriority()", 3, issue.getPriority().getId());
        assertEquals("Issue.getLink() - " + issue.getLink(), null, issue.getLink());

        assertEquals("Issue.getFixVersions().size()", 0, issue.getFixVersions().size());

        assertEquals("Issue.getAffectsVersions().size()", 1, issue.getAffectsVersions().size());
        final List<Version> affectsVersions = issue.getAffectsVersions();
        Version version = (Version) affectsVersions.get(0);
        assertTrue("AffectsVersion instance of Version", version instanceof Version);
        assertEquals("Version.getName()", "maven-shared-io-3.0.0", version.getName());
        assertEquals("Version.getReleased()", true, version.getReleased());
        assertEquals("Version.getArchived()", false, version.getArchived());
        assertEquals("Version.getReleaseDate()", 23, version.getReleaseDate().getDate());
        assertEquals("Version.getSequence()", 0, version.getSequence());
        assertEquals("Version.getId()", 12334278, version.getId());

        assertEquals("Issue.getComponents().size()", 1, issue.getComponents().size());
        assertTrue("Issue.getComponents instance of Component", issue.getComponents().get(0) instanceof Component);
        Component component = (Component) issue.getComponents().get(0);
        assertEquals("Component.getName()", "maven-shared-io", component.getName());
        assertEquals("Component.getId()", 12326440, component.getId());

    }
}
