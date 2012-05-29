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
package com.alta189.cyborg.rest.factoids;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import static com.alta189.cyborg.factoids.FactoidManager.getDatabase;

@Path("/factoids")
public class FactoidProvider {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Factoid> getFactoids() {
		List<Factoid> result = new ArrayList<Factoid>();
		for (com.alta189.cyborg.factoids.Factoid factoid : getDatabase().select(com.alta189.cyborg.factoids.Factoid.class).execute().find()) {
			result.add(new Factoid(factoid));
		}
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/range/{min}/{max}")
	public List<Factoid> getFactoids(@PathParam("min") int min, @PathParam("max") int max) {
		List<Factoid> result = new ArrayList<Factoid>();
		for (com.alta189.cyborg.factoids.Factoid factoid : getDatabase().select(com.alta189.cyborg.factoids.Factoid.class).where().greaterThanOrEqual("id", min).and().lessThanOrEqual("id", max).execute().find()) {
			result.add(new Factoid(factoid));
		}
		return result;
	}
}
