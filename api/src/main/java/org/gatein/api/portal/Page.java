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
import org.gatein.api.security.AccessRestriction;

import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 * @version $Revision$
 */
public interface Page
{
   /**
    * @return Page Id
    */
   Id getId();

   /**
    * @return Site to which this page belongs
    */
   Site getSite();

   /**
    * @return Name of the page
    */
   String getName();

   /**
    * @return Title of the page
    */
   String getTitle();

   /**
    * @param title Title of the page
    */
   void setTitle(String title);

   //TODO: set/get showMaxWindow?


   /**
    * @param type Type of AccessRestriction object to obtain
    * @return The AccessRestriction object. Can be null if page is public
    */
   AccessRestriction getAccessRestriction(AccessRestriction.Type type);

   /**
    * Updates access restrictions for the page. If new access restriction of Type.ACCESS is updated then
    * the page is automatically set to be not public. It is equivalent of calling setPublic(true)
    * @param accessRestriction AccessRestriction object to update. Cannot be null
    */
   void updateAccessRestriction(AccessRestriction accessRestriction);

   /**
    * @return true if page is accessible to anyone
    */
   boolean isPublic();

   /**
    * Switches page to public. If this method is invoked with value "true" then it will remove any related
    * AccessRestriction with Type.ACCESS
    * @param access
    */
   void setPublic(boolean access);

   /**
    * @param user Name of the user
    * @return true if given user can access the page
    */
   boolean hasAccess(String user);

   /**
    * Page Id
    */
   class Id
   {
      private final Site.Id siteId;
      private final String pageName;

      private Id(Site.Id siteId, String pageName)
      {
         this.siteId = siteId;
         this.pageName = pageName;
      }

      /**
       * @return Id of the site
       */
      public Site.Id getSiteId()
      {
         return siteId;
      }

      /**
       * @return Name of the page
       */
      public String getPageName()
      {
         return pageName;
      }

      /**
       * @return String representation of the Id
       */
      @Override
      public String toString()
      {
         return "Page.Id[pageName="+pageName+", " + siteId+"]";
      }

      /**
       * @param type Type of the site
       * @param siteName Name of the site
       * @param pageName Name of the page
       * @return The page id
       */
      public static Id create(Site.Type type, String siteName, String pageName)
      {
         return create(Site.Id.create(type, siteName), pageName);
      }

      /**
       * @param siteId Id of the site
       * @param pageName Name of the page
       * @return The page id
       */
      public static Id create(Site.Id siteId, String pageName)
      {
         return new Id(siteId, pageName);
      }

      @Override
      public boolean equals(Object o)
      {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Id id = (Id) o;

         if (!pageName.equals(id.pageName)) return false;
         if (!siteId.equals(id.siteId)) return false;

         return true;
      }

      @Override
      public int hashCode()
      {
         int result = siteId.hashCode();
         result = 31 * result + pageName.hashCode();
         return result;
      }
   }
}
