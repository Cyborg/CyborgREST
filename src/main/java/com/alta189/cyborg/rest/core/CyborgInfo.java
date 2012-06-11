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

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
public class CyborgInfo {
	private static final PeriodFormatter timeFormatter = new PeriodFormatterBuilder()
			.appendYears().appendSuffix(" years").appendSeparator(", ")
			.appendMonths().appendSuffix(" months").appendSeparator(", ")
			.appendWeeks().appendSuffix(" weeks").appendSeparator(", ")
			.appendDays().appendSuffix(" days").appendSeparator(", ")
			.appendHours().appendSuffix(" hours").appendSeparator(", ")
			.appendMinutes().appendSuffix(" minutes").appendSeparator(", ")
			.appendSeconds().appendSuffix(" seconds")
			.toFormatter();
	private String nick;
	private String ident;
	private String hostmask;
	private Set<Channel> channels;
	private long runningTime;
	private String runningTimeFormatted;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getHostmask() {
		return hostmask;
	}

	public void setHostmask(String hostmask) {
		this.hostmask = hostmask;
	}

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

	public long getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(long runningTime) {
		this.runningTime = runningTime;
		DateTime begin = new DateTime(System.currentTimeMillis());
		DateTime end = new DateTime(runningTime);
		Period period = new Period(end, begin);
		this.runningTimeFormatted = timeFormatter.print(period);
	}
}
