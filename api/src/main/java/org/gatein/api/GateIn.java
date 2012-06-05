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

import org.gatein.api.exception.EntityNotFoundException;
import org.gatein.api.portal.Site;
import org.gatein.api.portal.SiteQuery;
import org.gatein.api.commons.Range;
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

   List<Site> getSites(Site.Type siteType);

   List<Site> getSites(Site.Type siteType, Range range);

   Site getSite(Site.Id siteId);

   Site getSite(Site.Type type, String name);

   Site getDefaultSite();

   SiteQuery<Site> createSiteQuery();

   Site addSite(Site.Type siteType, String name);

   void removeSite(Site.Id siteId) throws EntityNotFoundException;

   void removeSite(Site.Type siteType, String name) throws EntityNotFoundException;

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
