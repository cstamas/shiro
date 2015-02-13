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

import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.mgt.DefaultSubjectFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;

/**
 * Subject factory of anonymous enable subjects.
 */
public class AnonymousSubjectFactory
    extends DefaultSubjectFactory
{
  private AnonymousConfigurationSource anonymousConfigurationSource;

  private PermissionResolver permissionResolver;

  public void setAnonymousConfigurationSource(final AnonymousConfigurationSource anonymousConfigurationSource) {
    this.anonymousConfigurationSource = anonymousConfigurationSource;
  }

  public void setPermissionResolver(final PermissionResolver permissionResolver) {
    this.permissionResolver = permissionResolver;
  }

  @Override
  public Subject createSubject(SubjectContext context) {
    return new AnonymousSubject(anonymousConfigurationSource, permissionResolver, super.createSubject(context));
  }
}
