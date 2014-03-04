package br.com.soeirosantos.remindme.service

class ColorService {

	def static fromHexaToRgb(hexaColor) {
		if (hexaColor) {
			def r =  Integer.valueOf( hexaColor.substring( 0, 2 ), 16 )
			def g = Integer.valueOf( hexaColor.substring( 2, 4 ), 16 )
			def b = Integer.valueOf( hexaColor.substring( 4, 6 ), 16 )
			return [r, g, b]
		}
	}
}
