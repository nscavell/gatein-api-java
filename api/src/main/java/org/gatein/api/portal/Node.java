/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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

import org.gatein.api.exception.EntityNotFoundException;

import java.net.URI;
import java.util.Date;

/**
 * @author <a href="mailto:nscavell@redhat.com">Nick Scavelli</a>
 */
public interface Node extends Iterable<Node>
{
   Id getId();

   String getName();

   Node getParent();

   Node getChild(String name);

   Node getDescendant(String... path);

   void removeChild(String name) throws EntityNotFoundException;

   void removeDescendant(String... path) throws EntityNotFoundException;

   Node addChild(String name);

   int getCount();

   URI getURI();

   Label getLabel();

   String getIcon();

   void setIcon(String icon);

   Page getPage();

   Page.Id getPageReference();

   void setPageReference(Page.Id pageId);

   Visibility getVisibility();

   /**
    * The start date of the publication of the navigation node.
    *
    * @return the publication start date
    */
   Date getStartPublicationDate();

   /**
    * The end date of the publication of the navigation node.
    *
    * @return the publication end date
    */
   Date getEndPublicationDate();

   /**
    * Set's the publication of the navigation node. This will set the visibility to {@link Visibility#PUBLICATION}
    *
    * @param start the start date of the publication of the navigation node
    * @param end   the end date of the publication of the navigation node
    */
   void setPublication(Date start, Date end);

   /**
    * Set's the publication of the navigation node. This will set the visibility to {@link Visibility#PUBLICATION}. This also
    * removes any end publication date data.
    *
    * @param start the start date of the publication of the navigation node
    */
   void setPublication(Date start);

   /**
    * Removes the publication data of the navigation node, setting the visibility to the default {@link Visibility#VISIBLE}
    */
   void removePublication();

   /**
    * Sets the visibility of the navigation node.
    *
    * @param visible setting to true will set the node to it's default state of {@link Visibility#VISIBLE}, setting to false
    *                will set the node to it's hidden state {@link Visibility#HIDDEN}
    */
   void setVisible(boolean visible);

   public static enum Visibility
   {
      VISIBLE,
      HIDDEN,
      PUBLICATION,
      SYSTEM
   }

   class Id
   {
      private final Site.Id siteId;
      private final String[] path;

      private Id(Site.Id siteId, String[] path)
      {
         this.siteId = siteId;
         this.path = path;
      }

      public Site.Id getSiteId()
      {
         return siteId;
      }

      public String[] getPath()
      {
         return path;
      }

      public String getPathAsString()
      {
         if (path == null) return null;

         StringBuilder sb = new StringBuilder();
         for (int i=0; i<path.length; i++)
         {
            if (i > 0)
            {
               sb.append('/');
            }
            sb.append(path[i]);
         }

         return sb.toString();
      }

      @Override
      public String toString()
      {
         return "Node.Id[path=" + getPathAsString() + ", " + siteId + "]";
      }

      public static Id create(Site.Id siteId, String...path)
      {
         return new Id(siteId, path);
      }
   }
}
