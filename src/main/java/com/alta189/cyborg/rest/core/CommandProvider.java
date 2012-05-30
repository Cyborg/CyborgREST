/*
 * Copyright (C) 2012 CyborgDev <cyborg@alta189.com>
 *
 * This file is part of CyborgREST
 *
 * CyborgREST is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CyborgREST is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.cyborg.rest.core;

import com.alta189.cyborg.Cyborg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.alta189.cyborg.rest.JSONUtil.getCountJSON;

@Path("/commands")
public class CommandProvider {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Command> getCommands() {
		List<Command> result = new ArrayList<Command>();
		for (com.alta189.cyborg.api.command.Command command : Cyborg.getInstance().getCommandManager().getCommandMap().getCommands()) {
			if (!command.isHiddenFromList())
				result.add(new Command(command));
		}
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/count")
	public String getCommandCount() {
		return (getCountJSON(getCommands().size()));
	}

}
