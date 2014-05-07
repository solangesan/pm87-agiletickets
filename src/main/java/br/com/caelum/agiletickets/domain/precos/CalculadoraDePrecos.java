package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	private static final Double DEZ_POR_CENTO = 0.10;
	private static final Double VINTE_POR_CENTO = 0.20;

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			preco = aplicaAumentoNosUltimosIngressos(sessao, DEZ_POR_CENTO);
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			preco = aplicaAumentoNosUltimosIngressos(sessao, VINTE_POR_CENTO);
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(DEZ_POR_CENTO)));
			}
		}  else {
			//nao aplica aumento para teatro (quem vai é pobretão)
			preco = sessao.getPreco();
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}


	public static BigDecimal aplicaAumentoNosUltimosIngressos(Sessao sessao, Double porcentagem) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(porcentagem)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

}