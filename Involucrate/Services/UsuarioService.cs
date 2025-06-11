using Involucrate.Models;
using Newtonsoft.Json;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

public class UsuarioService
{
    private readonly HttpClient _httpClient;

    public UsuarioService()
    {
        _httpClient = new HttpClient();
    }

    public async Task<bool> ComprobarUsuarioAsync(string correo, string contrasena)
    {
        var usuarioData = new
        {
            CorreoElectronico = correo,
            Contrasena = contrasena
        };

        var json = JsonConvert.SerializeObject(usuarioData);
        var content = new StringContent(json, Encoding.UTF8, "application/json");

        var response = await _httpClient.PostAsync("http://localhost:8080/usuarios/comprobar", content);
        if (response.IsSuccessStatusCode)
        {
            var result = await response.Content.ReadAsStringAsync();
            return bool.Parse(result);
        }

        return false;
    }

    public async Task<bool> RegistrarUsuarioAsync(Usuario usuario)
    {
        var json = JsonConvert.SerializeObject(usuario);
        var content = new StringContent(json, Encoding.UTF8, "application/json");

        var response = await _httpClient.PostAsync("http://localhost:8080/usuarios/add", content);
        return response.IsSuccessStatusCode;
    }
}
