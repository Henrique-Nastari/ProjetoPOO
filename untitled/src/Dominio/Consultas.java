package Dominio;

public class Consultas {
        private int consultaId;
        private String dataConsulta;
        private String procedimento;

        public Consultas(){}
        public Consultas(int consultaId, String dc, String p){
            this.consultaId = consultaId;
            dataConsulta = dc;
            procedimento = p;
        }

        public int getConsultaId() {
            return consultaId;
        }
        public void setConsultaId(int consultaId) {
            this.consultaId = consultaId;
        }
        public String getDataConsulta() {
            return dataConsulta;
        }
        public void setDataConsulta(String dataConsulta) {
            this.dataConsulta = dataConsulta;
        }
        public String getProcedimento(){
            return procedimento;
        }
        public void setProcedimento(String procedimento){
            this.procedimento = procedimento;
        }
}
