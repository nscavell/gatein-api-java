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

package org.gatein.api.portal;


import org.gatein.api.commons.PropertyType;

import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 * @version $Revision$
 */
public interface Page
{
   Id getId();

   Site getSite();

   String getName();

   String getTitle();

   void setTitle(String title);

   //TODO: set/get showMaxWindow?

   class Id
   {
      private final Site.Id siteId;
      private final String pageName;

      private Id(Site.Id siteId, String pageName)
      {
         this.siteId = siteId;
         this.pageName = pageName;
      }

      public Site.Id getSiteId()
      {
         return siteId;
      }

      public String getPageName()
      {
         return pageName;
      }

      @Override
      public String toString()
      {
         return "Page.Id[pageName="+pageName+", " + siteId+"]";
      }

      public static Id create(Site.Type type, String siteName, String pageName)
      {
         return create(Site.Id.create(type, siteName), pageName);
      }

      public static Id create(Site.Id siteId, String pageName)
      {
         return new Id(siteId, pageName);
      }
   }
}
