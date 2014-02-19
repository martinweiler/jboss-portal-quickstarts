/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.quickstarts.portal.simplest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.portlet.GenericPortlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * A portlet to test URL parameters, created to verify GTNPORTAL-3389.
 *
 * @author Peter Palaga
 * @author Martin Weiler
 */
public class PortalURLParameterTestPortlet extends GenericPortlet {
    private static final Logger log = Logger.getLogger(PortalURLParameterTestPortlet.class.getName());

    /**
     * Serves the VIEW mode. Writes "Hello World !" to the response writer.
     *
     * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void doView(RenderRequest request, RenderResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Portal URL Parameter test portlet</h1>");
        writer.write("<div>To test this portlet, add a query string with parameter 'myparameter' to the URL, eg: ?myparameter=test</div>");
        String myParam = ((org.gatein.pc.portlet.impl.jsr168.api.RenderRequestImpl) request).getRealRequest().getParameter("myparameter");
        if(myParam!=null && !"".equals(myParam)) {
            writer.write("<div>request parameter 'myparameter': <b>" + myParam + "</b></div>");
        }        
        writer.close();
    }
}
