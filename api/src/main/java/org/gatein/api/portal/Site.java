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
import org.gatein.api.exception.EntityNotFoundException;

import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 * @version $Revision$
 */
public interface Site
{

   Id getId();

   Label getLabel();

   String getDescription();

   void setDescription(String description);

   List<Page> getPages();

   Page getPage(String pageName);

   void removePage(String pageName) throws EntityNotFoundException;

   //
   Navigation getNavigation();

   //TODO: Attributes

   <T> T getProperty(PropertyType<T> property);

   <T> void setProperty(PropertyType<T> property, T value);

   public class Id
   {
      private Type type;

      private String name;

      private Id(Type type, String name)
      {
         if (type == null) throw new IllegalArgumentException("Type cannot be null");
         if (name == null) throw new IllegalArgumentException("name cannot be null");

         this.type = type;
         this.name = name;
      }

      public static Id create(Type type, String name)
      {
         return new Id(type, name);
      }

      public static Id site(String siteName)
      {
         return create(Type.SITE, siteName);
      }

      public static Id space(String...groupName)
      {
         StringBuilder groupId = new StringBuilder();
         for (String s : groupName)
         {
            groupId.append("/")
            .append(s);
         }

         return create(Type.SPACE, groupId.toString());
      }

      public static Id dashboard(String userName)
      {
         return create(Type.DASHBOARD, userName);
      }

      public Type getType()
      {
         return type;
      }

      public String getName()
      {
         return name;
      }

      @Override
      public String toString()
      {
         return "Site.Id[type="+type+", name="+name+"]";
      }
   }

   public static enum Type
   {
      SITE, SPACE, DASHBOARD
   }

}
