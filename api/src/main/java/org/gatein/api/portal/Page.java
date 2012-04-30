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
   String getId();

   PageType getType();

   void setType(PageType name);

   Site getSite();

   String getName();

   String getTitle();

   void setTitle(String title);

   //TODO: ??
   List<Navigation> getNavigations();

   //TODO: set/get showMaxWindow?

   //TODO: Attributes

   <T> T getProperty(PropertyType<T> property);

   <T> void setProperty(PropertyType<T> property, T value);



}
