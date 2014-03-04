package br.com.soeirosantos.remindme.service

class ColorService {

	def static fromHexaToRgb(hexaColor) {
		if (hexaColor) {
			def r =  Integer.valueOf( hexaColor[0, 1], 16 )
			def g = Integer.valueOf( hexaColor[2, 3], 16 )
			def b = Integer.valueOf( hexaColor[4, 5], 16 )
			return [r, g, b]
		}
	}
}
