/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.ranking.api;

/**
 * Event generated by the {@link RankingModel} and sent to listeners registered
 * by the model.
 * <p>
 * The types of events:
 * <ul>
 * <li><b>REFRESH_RANKING:</b> The list of available ranking has been
 * updated. The listeners can call <code>RankingModel.getRankings()</code>
 * to get the newly created rankings</li>
 * 
 * @see RankingListener
 * @author Mathieu Bastian
 */
public interface RankingEvent {

    /**
     * <ul>
     * <li><b>REFRESH_RANKING:</b> The list of available ranking has been
     * updated. The listeners can call <code>RankingModel.getRankings()</code>
     * to get the newly created rankings</li>
     * </ul>
     */
    public enum EventType {

        REFRESH_RANKING
    };

    /**
     * Returns the type of event.
     * @return the type of this event
     */
    public EventType getEventType();

    /**
     * Returns the ranking model that generated the event.
     * @return the source of the event
     */
    public RankingModel getSource();

    /**
     * Returns <code>true</code> if this event is one of these in parameters.
     * @param type  the event types that are to be compared with this event
     * @return      <code>true</code> if this event is <code>type</code>,
     *              <code>false</code> otherwise
     */
    public boolean is(EventType... type);
}