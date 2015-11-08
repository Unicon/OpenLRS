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
package org.apereo.openlrs.storage.kinesis;

import java.util.Collection;
import java.util.List;

import org.apereo.openlrs.model.OpenLRSEntity;
import org.apereo.openlrs.storage.TierOneStorage;
import org.springframework.stereotype.Component;

/**
 * @author ggilbert
 *
 */
@Component("KinesisTierOneStorage")
public class KinesisTierOneStorage implements TierOneStorage<OpenLRSEntity> {

  @Override
  public OpenLRSEntity save(OpenLRSEntity entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OpenLRSEntity> saveAll(Collection<OpenLRSEntity> entities) {
    // TODO Auto-generated method stub
    return null;
  }

}
