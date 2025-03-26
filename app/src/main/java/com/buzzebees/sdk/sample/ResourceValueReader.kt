package com.buzzebees.sdk.sample

import android.content.Context
import android.content.res.Resources


class ResourceValueReader(context: Context, packageName: String? = null) {

    private val resources: Resources = context.resources
    private val resourcePackageName: String = packageName ?: context.packageName

    /**
     * Fetches the string resource value for the provided resource name.
     * This approach assumes that the resources are known at compile-time.
     *
     * @param resourceName The name of the string resource to retrieve.
     * @return The string value or `null` if the resource is not found.
     */
    fun getString(resourceName: String): String? {
        return try {
            val resourceId = getResourceId(resourceName, "string")
            resources.getString(resourceId)
        } catch (e: Resources.NotFoundException) {
            null
        }
    }

    /**
     * Fetches the integer resource value for the provided resource name.
     *
     * @param resourceName The name of the integer resource to retrieve.
     * @return The integer value or `null` if the resource is not found.
     */
    fun getInt(resourceName: String): Int? {
        return try {
            val resourceId = getResourceId(resourceName, "integer")
            resources.getInteger(resourceId)
        } catch (e: Resources.NotFoundException) {
            null
        }
    }

    /**
     * Fetches the boolean resource value for the provided resource name.
     *
     * @param resourceName The name of the boolean resource to retrieve.
     * @return The boolean value or `null` if the resource is not found.
     */
    fun getBoolean(resourceName: String): Boolean? {
        return try {
            val resourceId = getResourceId(resourceName, "bool")
            resources.getBoolean(resourceId)
        } catch (e: Resources.NotFoundException) {
            null
        }
    }

    /**
     * Helper function to get the resource ID for a given resource name and type.
     */
    private fun getResourceId(resourceName: String, resourceType: String): Int {
        val resourceId = resources.getIdentifier(resourceName, resourceType, resourcePackageName)
        if (resourceId == 0) {
            throw Resources.NotFoundException("Resource not found: $resourceName")
        }
        return resourceId
    }
}
