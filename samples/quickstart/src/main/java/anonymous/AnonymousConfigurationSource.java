/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-2015 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package anonymous;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Current example in-memory configuration. This would refer to some real store or configuration source.
 */
public class AnonymousConfigurationSource
{
  private boolean enabled;

  private boolean sessionCreationEnabled;

  private String principal;

  private String originatingRealm;

  private Set<String> roles;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isSessionCreationEnabled() {
    return sessionCreationEnabled;
  }

  public void setSessionCreationEnabled(final boolean sessionCreationEnabled) {
    this.sessionCreationEnabled = sessionCreationEnabled;
  }

  public String getPrincipal() {
    return principal;
  }

  public void setPrincipal(final String principal) {
    this.principal = principal;
  }

  public String getOriginatingRealm() {
    return originatingRealm;
  }

  public void setOriginatingRealm(final String originatingRealm) {
    this.originatingRealm = originatingRealm;
  }

  public Set<String> getRoles() {
    return roles;
  }

  public void setRoles(final Set<String> roles) {
    this.roles = roles;
  }

  public AnonymousConfiguration getConfiguration() {
    // TODO: would resolve roles also into permissions, but for brewity now it's hardcoded
    return new AnonymousConfiguration(enabled, sessionCreationEnabled, principal, originatingRealm, roles,
        ImmutableSet.<Permission>of(new WildcardPermission("anon:read")));
  }
}
