package com.github.marquesbmc.repository;

import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.marquesbmc.Util;
import com.github.marquesbmc.model.storeprocedures.DadosNotaEmpenhoOGUSP017;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class OGUSP017Repository {

	@Inject
	@DataSource("db2")
	AgroalDataSource usersDataSource;

	public List<DadosNotaEmpenhoOGUSP017> getListaTeste(Long num) {
		System.out.println("Iniciando ...");
		Connection con = null;
		List<DadosNotaEmpenhoOGUSP017> listaDadosNotaEmpenho = new ArrayList<DadosNotaEmpenhoOGUSP017>();
		try {
			int coErro = 0;
			String deErro = "";
			con = usersDataSource.getConnection();

			CallableStatement cstmt = null;
			ResultSet rs;

			cstmt = con.prepareCall("{call OGU.OGUSP017_DADOS_NOTA_DE_EMPENHO(?,?,?)}");

			int param = 1;
			cstmt.setLong(param++, 1000306);
			cstmt.registerOutParameter(param++, Types.INTEGER);
			cstmt.registerOutParameter(param++, Types.VARCHAR);
			cstmt.execute();

			coErro = cstmt.getInt(2);
			deErro = cstmt.getString(3);

			if (coErro == 0) {
				rs = cstmt.getResultSet();
				SimpleDateFormat formatoData = new SimpleDateFormat(Util.FORMATO_DATA, Util.LOCALE_PT_BR);
				DecimalFormat formatoMoeda = new DecimalFormat(Util.FORMATO_MOEDA,
						new DecimalFormatSymbols(Util.LOCALE_PT_BR));
				formatoMoeda.setRoundingMode(RoundingMode.UP);

				while (rs.next()) {
					DadosNotaEmpenhoOGUSP017 dadosNotaEmpenho = new DadosNotaEmpenhoOGUSP017();
					dadosNotaEmpenho.setCodNotaEmpenho(rs.getString(2));

					if (rs.getDate(3) != null) {
						String data = formatoData.format(rs.getDate(3));
						dadosNotaEmpenho.setDataNotaEmpenho(data);
					}

					String valor = formatoMoeda.format(rs.getDouble(4));
					dadosNotaEmpenho.setVlrNotaEmpenho(valor);

					dadosNotaEmpenho.setSituacaoNotaEmpenho(Util.toCaixaAlta(rs.getString(6)));
					listaDadosNotaEmpenho.add(dadosNotaEmpenho);
				}

			} else if (coErro != 19) { // 19 - Lista Vazia
				System.out.println("erro");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saindo ....");
		return listaDadosNotaEmpenho;
	}

}
