//=============================================================================
//===	Copyright (C) 2001-2009 Food and Agriculture Organization of the
//===	United Nations (FAO-UN), United Nations World Food Programme (WFP)
//===	and United Nations Environment Programme (UNEP)
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
//===	Rome - Italy. email: geonetwork@osgeo.org
//==============================================================================
package org.fao.geonet.kernel.harvest.harvester.localfilesystem;

import jeeves.exceptions.BadInputEx;
import jeeves.utils.Util;
import org.fao.geonet.kernel.DataManager;
import org.fao.geonet.kernel.harvest.harvester.AbstractParams;
import org.jdom.Element;

/**
 * Params for local filesystem harvesting.
 * 
 * @author heikki doeleman
 *
 */
public class LocalFilesystemParams extends AbstractParams {

	public String icon;
	public String directoryname;
	public boolean recurse;
	public boolean nodelete;
	
	public LocalFilesystemParams(DataManager dm) {
		super(dm);
	}
	//---------------------------------------------------------------------------
	//---
	//--- Create : called when a new entry must be added. Reads values from the
	//---          provided entry, providing default values
	//---
	//---------------------------------------------------------------------------

	public void create(Element node) throws BadInputEx {
		super.create(node);
		Element site = node.getChild("site");
		directoryname = Util.getParam(site, "directory", "");
		icon = Util.getParam(site, "icon",   "filesystem.gif");
		String recurseString = Util.getParam(site, "recurse", "true");
		recurse = (recurseString.equals("on") || recurseString.equals("true"));
		String nodeleteString = Util.getParam(site, "nodelete", "true");
		nodelete = (nodeleteString.equals("on") || nodeleteString.equals("true"));
		System.out.println("recurse: " + recurse + " nodelete: " + nodelete);
	}

	//---------------------------------------------------------------------------
	//---
	//--- Update : called when an entry has changed and variables must be updated
	//---
	//---------------------------------------------------------------------------

	public void update(Element node) throws BadInputEx {
		super.update(node);
		Element site = node.getChild("site");
		directoryname = Util.getParam(site, "directory", "");
		icon = Util.getParam(site, "icon",   "filesystem.gif");
		String recurseString = Util.getParam(site, "recurse", "true");
		recurse = (recurseString.equals("on") || recurseString.equals("true"));
		String nodeleteString = Util.getParam(site, "nodelete", "true");
		nodelete = (nodeleteString.equals("on") || nodeleteString.equals("true"));
		System.out.println("recurse: " + recurse + " nodelete: " + nodelete);
	}

	public LocalFilesystemParams copy() {
		LocalFilesystemParams copy = new LocalFilesystemParams(dm);
		copyTo(copy);
		copy.icon = icon;
		copy.directoryname = directoryname;
		copy.recurse = recurse;
		copy.nodelete = nodelete;
		return copy;		
	}
}