/**
 * Copyright 2015 Unicon (R) Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package org.apereo.openlrs.services.caliper;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.Logger;
import org.apereo.openlrs.model.OpenLRSEntity;
import org.apereo.openlrs.model.caliper.CaliperEvent;
import org.apereo.openlrs.model.event.EventConversionService;
import org.apereo.openlrs.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author ggilbert
 * @author Lance E Sloan <lsloan at umich dot edu>
 */
@Service
public class CaliperService extends EventService {

    private Logger log = Logger.getLogger(CaliperService.class);

    @Autowired
    private EventConversionService eventConversionService;

    public void post(String organizationId, CaliperEvent caliperEvent) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("Caliper event: %s", caliperEvent));
        }

        getTierOneStorage().save(caliperEvent);
    }

    public List<JsonNode> getJsonNodes(Map<String, String> filterMap) {
        List<JsonNode> result = null;
        List<OpenLRSEntity> entities = null;

        if (filterMap != null && !filterMap.isEmpty()) {
            entities = getTierTwoStorage().findWithFilters(filterMap);
        } else {
            entities = getTierTwoStorage().findAll();
        }

        result = eventConversionService.toCaliperJsonCollection(entities);

        return result;
    }

    /*
    public Page<Event> getByContext(String context, Pageable pageable) {
    Page<OpenLRSEntity> page = getTierTwoStorage().findByContext(context,pageable);
    return eventConversionService.toCaliperPage(page);
  }

  public Page<Event> getByUser(String user, Pageable pageable) {
    Page<OpenLRSEntity> page = getTierTwoStorage().findByUser(user, pageable);
    return eventConversionService.toCaliperPage(page);
  }

  public Page<Event> getByContextAndUser(String context, String user,
      Pageable pageable) {
    Page<OpenLRSEntity> page = getTierTwoStorage().findByContextAndUser(
        context, user, pageable);
    return eventConversionService.toCaliperPage(page);
  }
  */

}