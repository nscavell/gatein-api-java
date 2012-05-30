/*
 * JBoss, a division of Red Hat
 * Copyright 2011, Red Hat Middleware, LLC, and individual
 * contributors as indicated by the @authors tag. See the
 * copyright.txt in the distribution for a full listing of
 * individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.gatein.api;

import org.gatein.api.portal.Dashboard;
import org.gatein.api.portal.Navigation;
import org.gatein.api.portal.PortalObject;
import org.gatein.api.portal.PortalObjectQuery;
import org.gatein.api.portal.Site;
import org.gatein.api.commons.Range;
import org.gatein.api.portal.Space;
import org.gatein.api.commons.PropertyType;

import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 * @version $Revision$
 */
public interface GateIn
{
   String GATEIN_API = "org.gatein.api.instance";

   //
   List<Site> getSites();

   List<Site> getSites(Range range);

   Site getSite(String siteId);

   Site getDefaultSite();

   PortalObjectQuery<Site> createSiteQuery();

   Site addSite(String name);


   //
   List<Space> getSpaces();

   List<Space> getSpaces(Range range);

   Space getSpace(String... groupId);

   Space getSpace(String spaceId);

   PortalObjectQuery<Space> createSpaceQuery();

   Space addSpace(String name, String groupId);


   //
   List<Dashboard> getDashboards();

   List<Dashboard> getDashboards(Range range);

   Dashboard getDashboard(String dashboardId);

   PortalObjectQuery<Dashboard> createDashboardQuery();


   //
   Navigation getNavigation(String navigationId);

   Navigation getNavigation(String... path);



   //

   <T> T getProperty(PropertyType<T> property);

   <T> void setProperty(PropertyType<T> property, T value);


   //
   String LIFECYCLEMANAGER_TYPE_NAME = "org.gatein.api.lifecyclemanager";

   PropertyType<LifecycleManager> LIFECYCLE_MANAGER = new PropertyType<LifecycleManager>(LIFECYCLEMANAGER_TYPE_NAME)
   {
   };

   LifecycleManager NO_OP_MANAGER = new LifecycleManager()
   {
      public void begin()
      {
         // do nothing
      }

      public void end()
      {
         // do nothing
      }
   };

   public interface LifecycleManager
   {
      void begin();

      void end();
   }

}
