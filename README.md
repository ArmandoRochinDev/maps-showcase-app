# maps-showcase-app
MapsShowcaseApp es una aplicacion de ejemplo para mostrar Maps SDK android y OpenRouteService

## OpenRouteService
<a href="https://openrouteservice.org/">OpenRouteService</a> Our classic route planning tool enables you to use most of the openrouteservice API with only a few clicks on a map. 

## Maps Sdk Android
<a href="https://developers.google.com/maps/documentation/android-sdk/overview">Maps Sdk Android</a> con el SDK de Maps para Android, puedes agregar mapas a tu app para Android.

## Prerrequisitos
Agrega tu Api Key de OpenRouteService en el archivo `local.properties`:
```
OPEN_ROUTE_KEY=<KEY>
```
Crer el archivo `google_maps_api.xml` en la ruta `res/values` con el siguiente contenido:
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="google_maps_key" translatable="false" templateMergeStrategy="preserve">
      <YOUR_GOOGLE_MAPS_API_KEY>
    </string>
</resources>
```

## Licence
    MIT License

    Copyright (c) 2023 Armando Rochin

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
