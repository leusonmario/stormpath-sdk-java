/*
* Copyright 2015 Stormpath, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.stormpath.sdk.impl.oauth;

import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.oauth.AccessToken;
import com.stormpath.sdk.oauth.GrantAuthenticationToken;
import com.stormpath.sdk.oauth.JwtAuthenticationResult;
import com.stormpath.sdk.oauth.JwtAuthenticationResultBuilder;

/**
 * @since 1.0.RC5.1
 */
public class DefaultJwtAuthenticationResultBuilder implements JwtAuthenticationResultBuilder {

    private AccessToken accessToken;

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public DefaultJwtAuthenticationResultBuilder(AccessToken accessToken) {
        Assert.notNull(accessToken, "grantAuthenticationToken cannot be null.");
        this.accessToken = accessToken;
    }

    @Override
    public JwtAuthenticationResult build() {
        Assert.notNull(this.accessToken, "accessToken has not been set. It is a required attribute.");
        return new DefaultJwtAuthenticationResult(this);
    }
}
