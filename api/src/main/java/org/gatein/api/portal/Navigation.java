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
import org.gatein.api.commons.Range;

import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 * @version $Revision$
 */
public interface Navigation
{

   //TODO: extended label? [language/label]
   //TODO: publication date/time? [start/end]
   //TODO: Icon?
   //TODO: Localized description and displayName

   String PUBLICATION_DATE_START_NAME = "org.gatein.api.portal.navigation.publication_date_start";

   PropertyType<Date> PUBLICATION_DATE_START = new PropertyType<Date>(PUBLICATION_DATE_START_NAME){};

   String PUBLICATION_DATE_END_NAME = "org.gatein.api.portal.navigation.publication_date_end";

   PropertyType<Date> PUBLICATION_END_START = new PropertyType<Date>(PUBLICATION_DATE_END_NAME){};


   String getId();

   String getName();

   String getDisplayName();

   void setDisplayName(String displayName);

   boolean isVisible();

   void setVisible(boolean visible);

   Page getTargetPage();

   void setTargetPage(Page target);

   void setTargetPage(String targetId);

   URI getURI();

   PortalObject getPortalObject();

   Navigation getParent();

   int getIndex();

   Navigation getChild(String name);

   List<Navigation> getChildren();

   int getChildrenCount();

   List<Navigation> getChildren(Range range);

   void removeChild(String name);

   Navigation addChild(String name);

   void moveUp();

   void moveDown();


   //TODO: Attributes

   <T> T getProperty(PropertyType<T> property);

   <T> void setProperty(PropertyType<T> property, T value);


}
