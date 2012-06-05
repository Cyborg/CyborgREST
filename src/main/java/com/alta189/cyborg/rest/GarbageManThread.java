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
package com.alta189.cyborg.rest;

public class GarbageManThread extends Thread {
	public final long waitTime;

	public GarbageManThread(long waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException ignored) {
			}
			if (CyborgREST.isDebug()) {
				System.out.println("Garbage man is collecting the trash");
			}
			System.gc();
		}
	}
}
