package org.codehaus.swizzle.jirareport;

import org.codehaus.swizzle.jira.Jira;

import junit.framework.TestCase;
import org.codehaus.swizzle.jira.JiraRpc;

public abstract class SwizzleJiraTestCase
    extends TestCase
{
    protected Jira getJira()
        throws Exception
    {
        Jira jira = new JiraRpc( "http://jira.codehaus.org/rpc/xmlrpc" );
        jira.login( "swizzle", "swizzle" );
        return jira;
    }
}
