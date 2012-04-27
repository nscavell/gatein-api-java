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


import org.exoplatform.services.organization.Group;
import org.exoplatform.services.organization.User;
import org.gatein.api.portal.Dashboard;
import org.gatein.api.portal.DashboardQuery;
import org.gatein.api.portal.Page;
import org.gatein.api.portal.Portal;
import org.gatein.api.portal.PortalQuery;
import org.gatein.api.portal.Range;
import org.gatein.api.portal.Site;
import org.gatein.api.portal.SpaceQuery;
import org.gatein.api.portal.Space;
import org.gatein.api.util.Type;

import java.net.URI;
import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @version $Revision$
 */
public interface GateIn
{
   String GATEIN_API = "org.gatein.api.instance";


   //
   List<Site> getSites();

   List<Site> getSites(Range range);

   Site getSite(String siteId);

   void removeSite(Site site);

   void removeSite(String siteId);


   //
   List<Portal> getPortals();

   List<Portal> getPortals(Range range);

   Portal getPortal(String portalId);

   Portal getDefaultPortal();

   PortalQuery createPortalQuery();

   Portal addPortal(String name);


   //
   List<Space> getSpaces();

   List<Space> getSpaces(Range range);

   Space getSpaceByGroupId(String groupId);

   Space getSpaceByGroup(Group group);

   Space getSpace(String spaceId);

   SpaceQuery createSpaceQuery();

   Space createSpace(String name, String groupId);


   //
   List<Dashboard> getDashboards();

   List<Dashboard> getDashboards(Range range);

   Dashboard getDashboardByUser(String userId);

   Dashboard getDashboardByUser(User user);

   Dashboard getDashboardById(String spaceId);

   DashboardQuery createDashboardQuery();




   <T> T getProperty(Type<T> property);

   <T> void setProperty(Type<T> property, T value);

//   String LIFECYCLEMANAGER_TYPE_NAME = "org.gatein.api.lifecyclemanager";
//   Type<LifecycleManager> LIFECYCLE_MANAGER = new Type<LifecycleManager>(LIFECYCLEMANAGER_TYPE_NAME)
//   {
//   };
//
//   LifecycleManager NO_OP_MANAGER = new LifecycleManager()
//   {
//      public void begin()
//      {
//         // do nothing
//      }
//
//      public void end()
//      {
//         // do nothing
//      }
//   };
//
//   public interface LifecycleManager
//   {
//      void begin();
//
//      void end();
//   }

}
