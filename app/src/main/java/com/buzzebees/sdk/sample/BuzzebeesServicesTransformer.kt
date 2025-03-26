package com.buzzebees.sdk.sample

import android.content.Context
import android.util.Log


/** Configurable Firebase options.  */
class BuzzebeesServicesTransformer {
    companion object {
        fun initializeFirebaseApp(context: Context) {
            // Fetch values using the old logic
            val apiKey = getElementValue(context, "app_id", "string")
            val baseUrl = getElementValue(context, "base_url", "string")
            val blobUrl = getElementValue(context, "blob_url", "string")
            val cdnUrl = getElementValue(context, "cdn_url", "string")
            val isDebugMode = getElementValue(context, "is_debug_mode", "bool")?.toBoolean()
            val moduleShoppingUrl = getElementValue(context, "module_shopping_url", "string")
            val moduleUrl = getElementValue(context, "module_url", "string")
            val prefixClientVersion = getElementValue(context, "prefix_client_version", "string")
            val sponsorId = getElementValue(context, "sponsor_id", "string")
            val subscriptionKey = getElementValue(context, "subscription_key", "string")
            val timeoutInterval = getElementValue(context, "timeout_interval", "integer")?.toInt()
            val urlSchemesMainProject = getElementValue(context, "url_schemes_main_project", "string")
            val webMisc = getElementValue(context, "web_misc", "string")
            val webShoppingUrl = getElementValue(context, "web_shopping_url", "string")
            val webUrl = getElementValue(context, "web_url", "string")

            // Log all the retrieved values
            Log.d("FirebaseOptionsTransformer", "app_id: $apiKey")
            Log.d("FirebaseOptionsTransformer", "base_url: $baseUrl")
            Log.d("FirebaseOptionsTransformer", "blob_url: $blobUrl")
            Log.d("FirebaseOptionsTransformer", "cdn_url: $cdnUrl")
            Log.d("FirebaseOptionsTransformer", "is_debug_mode: $isDebugMode")
            Log.d("FirebaseOptionsTransformer", "module_shopping_url: $moduleShoppingUrl")
            Log.d("FirebaseOptionsTransformer", "module_url: $moduleUrl")
            Log.d("FirebaseOptionsTransformer", "prefix_client_version: $prefixClientVersion")
            Log.d("FirebaseOptionsTransformer", "sponsor_id: $sponsorId")
            Log.d("FirebaseOptionsTransformer", "subscription_key: $subscriptionKey")
            Log.d("FirebaseOptionsTransformer", "timeout_interval: $timeoutInterval")
            Log.d("FirebaseOptionsTransformer", "url_schemes_main_project: $urlSchemesMainProject")
            Log.d("FirebaseOptionsTransformer", "web_misc: $webMisc")
            Log.d("FirebaseOptionsTransformer", "web_shopping_url: $webShoppingUrl")
            Log.d("FirebaseOptionsTransformer", "web_url: $webUrl")
        }


        // Helper function to get the value of a specific XML element
        private fun getElementValue(context: Context, resourceName: String, resourceType: String): String? {
            val reader = ResourceValueReader(context)
            return when (resourceType) {
                "string" -> reader.getString(resourceName)
                "integer" -> reader.getInt(resourceName)?.toString()
                "bool" -> reader.getBoolean(resourceName)?.toString()
                else -> null
            }
        }
    }
}
